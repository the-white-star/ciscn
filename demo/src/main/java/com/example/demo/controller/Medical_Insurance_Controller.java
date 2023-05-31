package com.example.demo.controller;


import com.example.demo.dao.Medical_Insurance_Mapper;
import com.example.demo.pojo.Log;
import com.example.demo.pojo.Medical_Insurance;
import com.example.demo.service.LogService;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/medical")         //使链接还有一个 /api
public class Medical_Insurance_Controller {
    @Autowired
    Medical_Insurance_Mapper medical_insurance_mapper;
    @Autowired
    LogService logService;

    @RequestMapping("insurance")
    public @ResponseBody
    Map<String, Object> Medical_Insurance_Mapper(@RequestParam("token") String token, HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                //List<Log> listLog = logService.listLog(page,10);
                int tmp = medical_insurance_mapper.isInsurance();
                if (tmp == 0) {
                    return StatusCode.error(2001, "数据不存在");
                } else {
                    // 记录下日志
                    Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                            "查看医保信息", userID, IPUtils.getIPAddress(request), "数据模块");
                    logService.insertLog(log);

                    List<Medical_Insurance> insurances = medical_insurance_mapper.findAll();
                    return StatusCode.success(insurances);
                }

            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }

    }//end Medical_Insurance_Mapper
}


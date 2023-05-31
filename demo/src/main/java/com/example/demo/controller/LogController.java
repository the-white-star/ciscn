package com.example.demo.controller;


import com.example.demo.pojo.Log;
import com.example.demo.pojo.User;
import com.example.demo.service.LogService;
import com.example.demo.service.UserService;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/log")         //使链接还有一个 /api
public class LogController {
    //理解为创建实体
    @Autowired
    LogService logService;
    @Autowired
    UserService userService;

    //get请求
    @GetMapping(value = "getList")
    public @ResponseBody
    Map<String,Object> getListLog(@RequestParam("token") String token,@RequestParam("page") int page, HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                List<Log> listLog = logService.listLog(page,10);

                // 记录下日志
                Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        "查看日志" ,userID, IPUtils.getIPAddress(request), "日志模块");
                logService.insertLog(log);

                return StatusCode.success(listLog);
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        }else{
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }
}

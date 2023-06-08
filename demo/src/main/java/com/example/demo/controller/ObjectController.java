package com.example.demo.controller;

import com.example.demo.pojo.Databases;
import com.example.demo.pojo.Log;
import com.example.demo.pojo.Medical_Insurance;
import com.example.demo.service.Databases_Service;
import com.example.demo.service.LogService;
import com.example.demo.service.ObjectService;
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
@RequestMapping(value = "/api/database")         //使链接还有一个 /api
public class ObjectController {
    @Autowired
    ObjectService objectService;
    @Autowired
    LogService logService;
    @Autowired
    Databases_Service databases_service;

    //get请求
    @GetMapping(value = "getList")
    public @ResponseBody
    Map<String,Object> getListTable(@RequestParam("tablesname_en") String tablesname_en,
                                    @RequestParam("token") String token,
                                    HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                int tmp = objectService.isobject(tablesname_en);
                if (tmp == 0) {
                    return StatusCode.error(2001, "数据不存在");
                } else {
                    // 记录下日志
                    List<Databases> databaseslist = databases_service.findAll();
                    String log_tablename="";   //获取中文名
                    for(Databases db : databaseslist)
                    {
                        if(db.gettablesname_en() == tablesname_en)
                        {
                            log_tablename=db.gettablesname();
                            break;
                        }
                    }
                    String message="查看";
                    message += log_tablename;
                    Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                            "查看医保信息", userID, IPUtils.getIPAddress(request), "数据模块");
                    logService.insertLog(log);

                    return StatusCode.success(objectService.findAll(tablesname_en));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }



}

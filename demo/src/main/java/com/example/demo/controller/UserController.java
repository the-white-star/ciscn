package com.example.demo.controller;

import com.example.demo.pojo.Log;
import com.example.demo.pojo.User;
import com.example.demo.service.LogService;
import com.example.demo.service.UserService;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import com.example.demo.utils.dataAuditLog.logSignature;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/user")         //使链接还有一个 /api
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LogService logService;

    @PostMapping(value = "login")
    public @ResponseBody Map<String,Object> login(@RequestBody User user, HttpServletRequest request) throws Exception {
        System.out.println(user.toString());
        //判断是否注册过
        int tmp = userService.isUserAndPass(user.getUserID(), user.getPassword());
        if ( tmp == 0 ) {
            //将结果存储下来

            // 记录下日志
            Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                   "登录失败，用户不存在" ,user.getUserID(),IPUtils.getIPAddress(request), "登录模块");
            logService.insertLog(log);

            return StatusCode.error(2001,"用户不存在");
        }
        //生成token
        JwtUtils jwt = JwtUtils.getInstance();
        String token = jwt
                .setClaim("userID",user.getUserID())
                .generateToken();

        Map<String, String> tmp3 = new HashMap<>();
        tmp3.put("token",token);
        //创建日志审计对象实例
        logSignature logSgn = new logSignature();
        // 创建 Gson 对象
        Gson gson = new Gson();
        // 将 Map 对象转换为 JSON 字符串
        String json = gson.toJson(tmp3);
        logSgn.sign("{action:select}\n" +
                        "{data:{" + json +"}\n" +
                        "{time:" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) +"}",
                user.getUserID());

        // 记录下日志
        Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                "登录成功" ,user.getUserID(),IPUtils.getIPAddress(request), "登录模块");
        logService.insertLog(log);

        //将结果存储下来
        return StatusCode.success(tmp3);
    }

    @PostMapping(value = "register")
    public @ResponseBody Map<String,Object> register(@RequestBody User user, HttpServletRequest request) throws Exception {
        //判断是否注册过
        int tmp = userService.isUser(user.getUserID());
        if ( tmp == 0 ) {
            //没有注册过，插入数据库
            userService.insertUser(user);

            //创建日志审计对象实例
            logSignature logSgn = new logSignature();
            // 创建 Gson 对象
            Gson gson = new Gson();
            // 将 Map 对象转换为 JSON 字符串
            String json = gson.toJson("注册成功");
            logSgn.sign("{action:insert}\n" +
                            "{data:{" + json +"}\n" +
                            "{time:" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) +"}",
                    user.getUserID());

            // 记录下日志
            Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                    "注册成功" ,user.getUserID(),IPUtils.getIPAddress(request), "注册模块");
            logService.insertLog(log);

            //将结果存储下来
            return StatusCode.success("注册成功");
        }else{
            // 记录下日志
            Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                    "注册失败，用户已存在" ,user.getUserID(),IPUtils.getIPAddress(request), "注册模块");
            logService.insertLog(log);

            return StatusCode.error(2000,"用户已存在！");
        }
    }

    @GetMapping(value = "tokenLogin")
    public @ResponseBody Map<String,Object> tokenLogin( @RequestParam("token") String token) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                User user = userService.getUser(userID);
                user.setPassword(null);
                return StatusCode.success(user);
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

package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/user")         //使链接还有一个 /api
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "login")
    public @ResponseBody Map<String,Object> login(@RequestBody User user) {
        System.out.println(user.toString());
        //判断是否注册过
        int tmp = userService.isUserAndPass(user.getUserID(), user.getPassword());
        if ( tmp == 0 ) {
            //将结果存储下来
            return StatusCode.error(2001,"用户不存在");
        }
        //生成token
        JwtUtils jwt = JwtUtils.getInstance();
        String token = jwt
                .setClaim("userID",user.getUserID())
                .generateToken();

        Map<String, String> tmp3 = new HashMap<>();
        tmp3.put("token",token);
        //将结果存储下来
        return StatusCode.success(tmp3);
    }

    @PostMapping(value = "register")
    public @ResponseBody Map<String,Object> register(@RequestBody User user) {
        //判断是否注册过
        int tmp = userService.isUser(user.getUserID());
        if ( tmp == 0 ) {
            //没有注册过，插入数据库
            userService.insertUser(user);
            //将结果存储下来
            return StatusCode.success("注册成功");
        }else{
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

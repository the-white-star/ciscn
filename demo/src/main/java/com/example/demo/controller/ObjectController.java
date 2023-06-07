package com.example.demo.controller;

import com.example.demo.pojo.Log;
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

    //get请求
    @GetMapping(value = "getList")
    public @ResponseBody
    Map<String,Object> getListTable(@RequestParam("tablename") String tablename) {
        return StatusCode.success(objectService.findAll(tablename));

    }

}

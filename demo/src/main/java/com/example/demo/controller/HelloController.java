
package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello SpringBoot";
    }


    @GetMapping("/cs")
    public Map<String, Object> cs() {
        Map<String, Object> map = new HashMap<>();

        map.put("msg", "helloworld");
        return map;
    }

    @PostMapping("/cspost")
    public Map<String, Object> cspost() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "helloworld");
        return map;
    }

    public static void importSqlFile(String filePath, String dbName, String username, String password) throws Exception {
        // 读取SQL文件内容
        String sql = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);

        // 连接数据库
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName
                + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                username, password);

        // 执行SQL语句
        Statement stmt = conn.createStatement();
        stmt.execute(sql);

        // 关闭连接
        stmt.close();
        conn.close();
    }

}




package com.example.demo.test;

import com.example.demo.dao.AllTableMapper;
import com.example.demo.dao.ObjectMapper;
import com.example.demo.dao.TableMapper;
import com.example.demo.service.AllTable_Service;
import com.example.demo.utils.StatusCode;
import com.example.demo.utils.dataAuditLog.logSignature;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuditTest {
    @Test
    public void test(){
        System.out.println("单元测试");
    }

    @Test
    public void test1() throws Exception {
        Map<String, String> tmp3 = new HashMap<>();
        tmp3.put("token","123");
        //创建日志审计对象实例
        logSignature logSgn = new logSignature();
        // 创建 Gson 对象
        Gson gson = new Gson();
        // 将 Map 对象转换为 JSON 字符串
        String json = gson.toJson(tmp3);
        logSgn.sign("{action:select}\n" +
                        "{data:{" + json +"}\n" +
                        "{time:" + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()) +"}",
                "1");
        //查看用户id为“yks”的数字签名链
        logSgn.getHchain().getUHC("1").printInfo();

        //验证签名
        System.out.println(logSgn.getHchain().getUHC("1"));
    }

    @Autowired
    AllTable_Service allTable_service;

    @Test
    public void test2() throws Exception{
        int tmp = allTable_service.isAllTable();
        if (tmp == 0) {
            //return StatusCode.error(2001, "数据不存在");
            System.out.println("null");
        } else {
            List<String> tablenames = allTable_service.findAll();
            System.out.println(tablenames.toString());
            //return StatusCode.success(tablenames);
        }
    }

    @Autowired
    TableMapper tableMapper;
    @Test
    public void test3(){
        String sql = "CREATE TABLE IF NOT EXISTS mytable (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
        tableMapper.createTable(sql);
        // System.out.println(objectMapper.findAll("logs").toString());
    }

//    @Test
//    public void test3() throws Exception {
//        // 读取SQL文件内容
//        String filePath= "C:\\Users\\gypgy\\Desktop\\travel.sql";
//        String dbName="travel";
//        String username ="root";
//        String password="wygjy";
//        String sql = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
//
//        // 连接数据库
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName
//                        + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
//                username, password);
//
//        // 执行SQL语句
//        Statement stmt = conn.createStatement();
//        stmt.execute(sql);
//
//        // 关闭连接
//        stmt.close();
//        conn.close();
//    }

}

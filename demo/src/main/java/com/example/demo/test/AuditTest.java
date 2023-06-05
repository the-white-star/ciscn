package com.example.demo.test;

import com.example.demo.dao.AllTableMapper;
import com.example.demo.dao.Medical_Insurance_Mapper;
import com.example.demo.dao.Medical_MedicalList_Mapper;
import com.example.demo.dao.Medical_PatientInfo_Mapper;
import com.example.demo.pojo.Medical_Insurance;
import com.example.demo.pojo.Medical_MedicalList;
import com.example.demo.pojo.Medical_PatientInfo;
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
    Medical_PatientInfo_Mapper medical_patientInfo_mapper;


    @Test
    public void test2() throws Exception{
        int tmp = medical_patientInfo_mapper.isPatientInfo();
        if (tmp == 0) {
            //return StatusCode.error(2001, "数据不存在");
            System.out.println("null");
        } else {
            List<Medical_PatientInfo> tablenames = medical_patientInfo_mapper.findAll();
            System.out.println(tablenames.toString());
            //return StatusCode.success(tablenames);
        }
    }
}

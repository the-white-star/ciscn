package com.example.demo.controller;


import com.example.demo.dao.Medical_MedicalList_Mapper;
import com.example.demo.pojo.Medical_MedicalList;
import com.example.demo.utils.StatusCode;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/medical")         //使链接还有一个 /api
public class Medical_MedicalList_Controller {
    @Autowired
    Medical_MedicalList_Mapper medical_medicalList_mapper;

    @RequestMapping("medicalList")
    public Map<String, Object> Medical_MedicalList_Mapper() {
        int tmp = medical_medicalList_mapper.isMedicalList();
        if (tmp == 0) {
            return StatusCode.error(2001, "数据不存在");
        } else {
            List<Medical_MedicalList> medicals = medical_medicalList_mapper.findAll();
            return StatusCode.success(medicals);
        }
    }
}


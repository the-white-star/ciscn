package com.example.demo.controller;


import com.example.demo.dao.Medical_Insurance_Mapper;
import com.example.demo.pojo.Medical_Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
public class Medical_Insurance_Controller {
    @Autowired
    Medical_Insurance_Mapper medical_insurance_mapper;

    @RequestMapping ("/api/medical/insurance")
    public List<Medical_Insurance> Medical_Insurance_Mapper(){
        List<Medical_Insurance> insurances = medical_insurance_mapper.findAll();
        return insurances;
    }
}


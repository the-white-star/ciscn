package com.example.demo.controller;


import com.example.demo.dao.Medical_MedicalList_Mapper;
import com.example.demo.pojo.Medical_MedicalList;
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
public class Medical_MedicalList_Controller {
    @Autowired
    Medical_MedicalList_Mapper medical_medicalList_mapper;

    @RequestMapping ("/api/medical/medicalList")
    public List<Medical_MedicalList> Medical_MedicalList_Mapper(){
        List<Medical_MedicalList> medicals = medical_medicalList_mapper.findAll();
        return medicals;
    }
}


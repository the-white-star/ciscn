package com.example.demo.controller;


import com.example.demo.dao.Medical_PatientInfo_Mapper;
import com.example.demo.pojo.Medical_PatientInfo;
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
public class Medical_PatientInfo_Controller {
    @Autowired
    Medical_PatientInfo_Mapper medical_patientInfo_mapper;

    @RequestMapping ("/api/medical/patientInfo")
    public List<Medical_PatientInfo> Medical_PatientInfo_Mapper(){
        List<Medical_PatientInfo> patients = medical_patientInfo_mapper.findAll();
        return patients;
    }
}


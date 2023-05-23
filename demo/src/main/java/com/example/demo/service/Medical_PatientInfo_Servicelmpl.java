package com.example.demo.service;

import com.example.demo.dao.Medical_PatientInfo_Mapper;
import com.example.demo.pojo.Medical_PatientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Medical_PatientInfo_Servicelmpl implements Medical_PatientInfo_Service {
    @Autowired
    Medical_PatientInfo_Mapper medical_patientInfo_mapper;

    @Override
    public List<Medical_PatientInfo> findAll() {
        return medical_patientInfo_mapper.findAll();
    }
}

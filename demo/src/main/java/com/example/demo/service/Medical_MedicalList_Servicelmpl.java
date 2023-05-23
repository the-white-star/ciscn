package com.example.demo.service;

import com.example.demo.dao.Medical_MedicalList_Mapper;
import com.example.demo.pojo.Medical_MedicalList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Medical_MedicalList_Servicelmpl implements Medical_MedicalList_Service {
    @Autowired
    Medical_MedicalList_Mapper medical_medicalList_mapper;

    @Override
    public List<Medical_MedicalList> findAll() {
        return medical_medicalList_mapper.findAll();
    }
}

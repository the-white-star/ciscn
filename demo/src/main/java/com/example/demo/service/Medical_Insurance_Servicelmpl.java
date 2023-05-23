package com.example.demo.service;

import com.example.demo.dao.Medical_Insurance_Mapper;
import com.example.demo.pojo.Medical_Insurance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Medical_Insurance_Servicelmpl implements Medical_Insurance_Service {
    @Autowired
    Medical_Insurance_Mapper medical_insurance_mapper;

    @Override
    public List<Medical_Insurance> findAll() {
        return medical_insurance_mapper.findAll();
    }
}

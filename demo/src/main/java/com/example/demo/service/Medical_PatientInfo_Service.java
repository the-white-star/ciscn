package com.example.demo.service;
import com.example.demo.pojo.Medical_PatientInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Medical_PatientInfo_Service {
    List<Medical_PatientInfo> findAll();
}

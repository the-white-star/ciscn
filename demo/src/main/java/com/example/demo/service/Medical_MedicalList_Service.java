package com.example.demo.service;
import com.example.demo.pojo.Medical_MedicalList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Medical_MedicalList_Service {
    List<Medical_MedicalList> findAll();
}

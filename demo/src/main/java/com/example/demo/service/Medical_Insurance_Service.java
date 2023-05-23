package com.example.demo.service;
import com.example.demo.pojo.Medical_Insurance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Medical_Insurance_Service {
    List<Medical_Insurance> findAll();
}

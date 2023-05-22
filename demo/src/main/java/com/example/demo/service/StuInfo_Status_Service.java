package com.example.demo.service;
import com.example.demo.pojo.StuInfo_Status;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfo_Status_Service {
    List<StuInfo_Status> findAll();
}

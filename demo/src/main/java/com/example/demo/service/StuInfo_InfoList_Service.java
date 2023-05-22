package com.example.demo.service;
import com.example.demo.pojo.StuInfo_InfoList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfo_InfoList_Service {
    List<StuInfo_InfoList> findAll();
}

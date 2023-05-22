package com.example.demo.service;
import com.example.demo.pojo.StuInfo_ScoreList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfo_ScoreList_Service {
    List<StuInfo_ScoreList> findAll();
}

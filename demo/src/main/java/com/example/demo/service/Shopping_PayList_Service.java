package com.example.demo.service;
import com.example.demo.pojo.Shopping_PayList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Shopping_PayList_Service {
    List<Shopping_PayList> findAll();
}

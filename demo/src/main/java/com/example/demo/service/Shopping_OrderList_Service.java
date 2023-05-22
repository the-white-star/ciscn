package com.example.demo.service;
import com.example.demo.pojo.Shopping_OrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Shopping_OrderList_Service {
    List<Shopping_OrderList> findAll();
}

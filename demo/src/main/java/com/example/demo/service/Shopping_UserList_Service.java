package com.example.demo.service;
import com.example.demo.pojo.Shopping_UserList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Shopping_UserList_Service {
    List<Shopping_UserList> findAll();
}

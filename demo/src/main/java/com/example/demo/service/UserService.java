package com.example.demo.service;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {
    int isUser(String userid);

    int isUserAndPass(String userID, String password);

    int insertUser(User user);

    User getUser(String userID);
}
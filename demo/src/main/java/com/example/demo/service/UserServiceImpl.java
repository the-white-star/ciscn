package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int isUser(String userID) {
        return userMapper.isUser(userID);
    }

    @Override
    public int isUserAndPass(String userID,String password) {
        return userMapper.isUserAndPass(userID,password);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUser(String userID){
        return userMapper.getUser(userID);
    }

}
package com.example.demo.service;


import com.example.demo.dao.TableMapper;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TableMapper tableMapper;

    @Override
    public void createTable(String sql) {
        tableMapper.createTable(sql);
    }
}

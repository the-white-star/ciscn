package com.example.demo.service;

import com.example.demo.dao.AllTableMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AllTable_ServiceImpl implements AllTable_Service {
    @Autowired
    AllTableMapper allTableMapper;

    @Override
    public List<String> findAll() {
        return allTableMapper.findAll();
    }

    @Override
    public int isAllTable() {
        return allTableMapper.isAllTable();
    }
}

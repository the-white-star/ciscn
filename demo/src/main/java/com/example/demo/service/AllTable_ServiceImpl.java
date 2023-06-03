package com.example.demo.service;

import com.example.demo.dao.AllTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

package com.example.demo.service;

import com.example.demo.dao.LogMapper;
import com.example.demo.pojo.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper logMapper;

    @Override
    public int insertLog(Log log) {
        return logMapper.insertLog(log);
    }

    @Override
    public List<Log> listLog(int page, int limit) {
        int first = (page - 1) * limit;
        int second = limit;
        List<Log> listLog = logMapper.listLog(first, second);
        return listLog;
    }
}

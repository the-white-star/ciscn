package com.example.demo.service;


import com.example.demo.dao.DatabasesMapper;
import com.example.demo.pojo.Databases;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class Databases_ServiceImpl implements Databases_Service{
    @Autowired
    DatabasesMapper databasesMapper;

    @Override
    public List<Databases> findAll(){return databasesMapper.findAll();}

    @Override
    public int isDatabases(){return databasesMapper.isDatabases();}

    @Override
    public List<Databases> listtables(int DBid){return databasesMapper.listtables(DBid);}

    @Override
    public int insertDatabases(Databases databases){return databasesMapper.insertDatabases(databases);}


}

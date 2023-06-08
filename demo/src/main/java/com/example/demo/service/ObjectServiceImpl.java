package com.example.demo.service;

import com.example.demo.dao.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ObjectServiceImpl  implements ObjectService {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<Map<String, Object>> findAll(String tablesname_en) {
        return objectMapper.findAll(tablesname_en);
    }

    @Override
    public int isobject(String tablesname_en){return objectMapper.isobject(tablesname_en);}
}

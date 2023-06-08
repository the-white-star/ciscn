package com.example.demo.service;

import java.util.List;
import java.util.Map;


public interface ObjectService {
    List<Map<String, Object>> findAll(String tablesname_en);
    int isobject(String tablesname_en);
}

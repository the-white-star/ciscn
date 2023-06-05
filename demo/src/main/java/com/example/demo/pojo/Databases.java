package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

//数据库汇总表
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Databases {
    private Long id;
    private String DBname;
    private String DBdescribe;
    private String tablesname;
    public Databases(long id, String DBname, String DBdescribe, String tablesname) {
        this.id = id;
        this.DBname = DBname;
        this.DBdescribe = DBdescribe;
        this.tablesname = tablesname;
    }
    public String getTablesname(){return tablesname;}
    public String getDBname(){return DBname;}
}

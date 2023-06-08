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
    private String tablesname_en;
    public Databases(long id, String DBname, String DBdescribe, String tablesname, String tablesname_en) {
        this.id = id;
        this.DBname = DBname;
        this.DBdescribe = DBdescribe;
        this.tablesname = tablesname;
        this.tablesname_en = tablesname_en;
    }
    public Long getId(){return id;}
    public String getDBname(){return DBname;}
    public String gettablesname(){return tablesname;}
    public String gettablesname_en(){return tablesname_en;}
}

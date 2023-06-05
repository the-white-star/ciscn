package com.example.demo.dao;

import com.example.demo.pojo.Databases;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DatabasesMapper {
    /**
     * 获取全部表信息
     */
    @Select("SELECT * FROM DBstruct")
    List<Databases> findAll();

    @Select("SELECT count(*) FROM DBstruct")
    int isDatabases();

    /**
     * 根据DBid返回对应的表
     */
    @Select("select * from DBstruct where id = #{DBid};")
    List<Databases> listtables(int DBid);

    /**
     * 添加新的数据库表结构
     */
    @Insert("insert into DBstruct(id,DBname,DBdescribe,tablesname) values(#{databases.id},#{databases.DBname},#{databases.DBdescribe},#{databases.tablesname})")
    int insertDatabases(@Param("databases") Databases databases);
}

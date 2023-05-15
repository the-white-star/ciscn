package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    /**
     * 判断用户是否存在
     */
    @Select("SELECT count(*) FROM faculty WHERE userID=#{userID}")
    int isUser(String userID);

    @Select("SELECT * FROM faculty WHERE userID=#{userID}")
    User getUser(String userID);

    @Select("SELECT count(*) FROM faculty WHERE userID=#{userID} and password=#{password}")
    int isUserAndPass(String userID, String password);

    /**
     * 添加新的用户信息
     */
    @Insert("insert into faculty(userID,password,email) values(#{userID},#{password},#{email})")
    int insertUser(User user);


}
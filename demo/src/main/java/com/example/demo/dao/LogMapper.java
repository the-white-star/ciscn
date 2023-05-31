package com.example.demo.dao;

import com.example.demo.pojo.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 添加新的日志信息
     */
    @Insert("insert into logs(createdAt,message,userID,ipAddress,module) values(#{log.createdAt},#{log.message},#{log.userID},#{log.ipAddress},#{log.module})")
    int insertLog(@Param("log") Log log);

    /**
     * 分页返回
     */
    @Select("select * from logs order by createdAt desc limit #{first},#{second};")
    List<Log> listLog(int first, int second);

    /**
     * @return 返回日志的总条数
     */
    @Select("select count(*) from logs;")
    int Logtotalpage();
}
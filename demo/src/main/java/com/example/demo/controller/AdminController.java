package com.example.demo.controller;


import com.example.demo.dao.AllTableMapper;
import com.example.demo.pojo.Databases;
import com.example.demo.pojo.Log;
import com.example.demo.pojo.Medical_Insurance;
import com.example.demo.service.AllTable_Service;
import com.example.demo.service.Databases_Service;
import com.example.demo.service.LogService;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api")         //使链接还有一个 /api
public class AdminController {
    @Autowired
    LogService logService;
    @Autowired
    Databases_Service databases_service;

    //数据查看日志
    @GetMapping(value = "Data_Viewing")
    public @ResponseBody
    Map<String, Object> getDataView(@RequestParam("token") String token, HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                // 记录下日志
                Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        "数据查看", userID, IPUtils.getIPAddress(request), "数据模块");
                logService.insertLog(log);
                Map<String, Object> map = new HashMap<>();
                map.put("msg", "data view!");
                return StatusCode.success(map);
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }//end getDataView


    //数据托管日志
    @GetMapping(value = "Data_Hosting")
    public @ResponseBody
    Map<String, Object> getDataHost(@RequestParam("token") String token, HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                // 记录下日志
                Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        "数据托管", userID, IPUtils.getIPAddress(request), "数据模块");
                logService.insertLog(log);
                Map<String, Object> map = new HashMap<>();
                map.put("msg", "data Host!");
                return StatusCode.success(map);
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }//end getDataHost

    //用户权限管理日志
    @GetMapping(value = "User_Rights_Management")
    public @ResponseBody
    Map<String, Object> getUserRights(@RequestParam("token") String token, HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                // 记录下日志
                Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                        "用户权限管理", userID, IPUtils.getIPAddress(request), "用户权限管理模块");
                logService.insertLog(log);
                Map<String, Object> map = new HashMap<>();
                map.put("msg", "user right manage!");
                return StatusCode.success(map);
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }//end getUserRights


//    //查看数据表结构
//    @GetMapping(value = "Table_Struct")
//    public @ResponseBody
//    Map<String, Object> getTable_Struct(@RequestParam("database_nanme") String database_name) {
//        int tmp = allTable_service.isAllTable();
//        if (tmp == 0) {
//            return StatusCode.error(2001, "数据不存在");
//        } else {
//            List<String> tablenames = allTable_service.findAll();
//            //System.out.println(tablenames.toString());
//            List<String> fintablenames = new ArrayList<String>();   //最终的结果
//            for (String tableName : tablenames) {
//                String[] parts = tableName.split("_"); // 拆分元素
//                if (parts[0].equals(database_name)) { // 判断是否匹配成功
//                    //System.out.println(tableName);
//                    fintablenames.add(tableName);
//                }
//            }
////            for (String tableName : tablenames) {
////                String prefix = tableName.substring(0, database_name.length()); // 截取前缀
////                if (prefix.equals(database_name)) { // 判断是否匹配成功
//////                    System.out.println(tableName);
////                    fintablenames.add(tableName);
////                }
////            }
//            return StatusCode.success(fintablenames);
//        }
//    }

    //显示全部数据库的名字和描述
//    @GetMapping(value = "databases")
//    public @ResponseBody
//    Map<String, Object> getDatabases() {
//        int tmp = databases_service.isDatabases();
//        if (tmp == 0) {
//            return StatusCode.error(2001, "数据不存在");
//        } else {
//            List<Databases> databaseslist = databases_service.findAll();
//            Set<String> finDB = new HashSet<>(); //去重
//            for (Databases db : databaseslist) {
//                finDB.add(db.getDBname());
//            }
//            return StatusCode.success(finDB);
//        }
//    }//end getDatabases

    //显示全部数据库的id、名字和描述
    @GetMapping(value = "databases")
    public @ResponseBody
   Map<String, Object> getDatabases() {
        int tmp = databases_service.isDatabases();
        if (tmp == 0) {
            return StatusCode.error(2001, "数据不存在");
        } else {
            List<Databases> databaseslist = databases_service.findAll();
            List<Map<String, Object>> result = new ArrayList<>();
            Set<Long> idSet = new HashSet<>(); // 用来去重
            for (Databases db : databaseslist) {
                Long id = db.getId();
                if (idSet.contains(id)) {
                    continue; // 如果已经存在相同的id，跳过这条记录
                }
                Map<String, Object> dbMap = new HashMap<>();
                dbMap.put("id", id);
                dbMap.put("DBname", db.getDBname());
                dbMap.put("DBdescribe", db.getDBdescribe());
                result.add(dbMap);
                idSet.add(id); // 将当前记录的id添加到Set中
            }
//            return result;
            return StatusCode.success(result);
        }
    }

    //根据数据库id显示数据库对应的表（包含中文和英文名）
    @GetMapping(value = "DB_tables")
    public @ResponseBody
    Map<String, Object> getTables(@RequestParam("DBid") int DBid) {
        List<Databases> listtables = databases_service.listtables(DBid);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Databases db : listtables) {
            Map<String, Object> dbMap = new HashMap<>();
            dbMap.put("tablesname", db.gettablesname());
            dbMap.put("tablesname_en", db.gettablesname_en());
            result.add(dbMap);
        }
//        return result;
        return StatusCode.success(result);
    }//end getTables

}

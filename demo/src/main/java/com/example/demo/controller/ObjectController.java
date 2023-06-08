package com.example.demo.controller;

import com.example.demo.dao.TableMapper;
import com.example.demo.pojo.Databases;
import com.example.demo.pojo.Log;
import com.example.demo.pojo.Medical_Insurance;
import com.example.demo.pojo.User;
import com.example.demo.service.Databases_Service;
import com.example.demo.service.LogService;
import com.example.demo.service.ObjectService;
import com.example.demo.service.UserService;
import com.example.demo.utils.IPUtils;
import com.example.demo.utils.JwtUtils;
import com.example.demo.utils.StatusCode;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController         //注解可以使结果以Json字符串的形式返回给客户端
@CrossOrigin                //解决跨域问题
@RequestMapping(value = "/api/database")         //使链接还有一个 /api
public class ObjectController {
    @Autowired
    ObjectService objectService;
    @Autowired
    LogService logService;
    @Autowired
    Databases_Service databases_service;
    @Autowired
    TableMapper tableMapper;

    //get请求
    @GetMapping(value = "getList")
    public @ResponseBody
    Map<String, Object> getListTable(@RequestParam("tablesname_en") String tablesname_en,
                                     @RequestParam("token") String token,
                                     HttpServletRequest request) {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            String userID = (String) claims.get("userID");
            try {
                int tmp = objectService.isobject(tablesname_en);
                if (tmp == 0) {
                    return StatusCode.error(2001, "数据不存在");
                } else {
                    // 记录下日志
                    List<Databases> databaseslist = databases_service.findAll();
                    String log_tablename = "";   //获取中文名
                    for (Databases db : databaseslist) {
                        if (db.gettablesname_en() == tablesname_en) {
                            log_tablename = db.gettablesname();
                            break;
                        }
                    }
                    String message = "查看";
                    message += log_tablename;
                    Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                            "查看医保信息", userID, IPUtils.getIPAddress(request), "数据模块");
                    logService.insertLog(log);

                    return StatusCode.success(objectService.findAll(tablesname_en));
                }
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }


    //上传数据库post请求
    @PostMapping(value = "update")
    public @ResponseBody
    Map<String, Object> updateDB(@RequestParam("token") String token,
                                 @RequestParam("file") MultipartFile file,
                                 @RequestParam("DBname") String DBname,
                                 @RequestParam("DBdescribe") String DBdescribe,
                                 @RequestParam("alltbname") String alltbname,
                                 HttpServletRequest request) throws Exception {
        JwtUtils jwt = JwtUtils.getInstance();
        Claims claims = jwt.check(token);
        if (claims != null) {
            Map<String, Object> result = new HashMap<>();
            String userID = (String) claims.get("userID");

            try {
                if (!file.isEmpty()) {
                    try (Scanner scanner = new Scanner(file.getInputStream())) {
                        scanner.useDelimiter(";\\s*"); // 设置分隔符为分号，并忽略分号后面的空白字符
                        //下面这部分是用来获取这个数据库的id
                        List<Databases> databaseslist = databases_service.findAll();
                        Set<Long> idSet = new HashSet<>();  //用来统计id个数
                        for (Databases db : databaseslist) {
                            Long id = db.getId();
                            if (idSet.contains(id)) {
                                continue; // 如果已经存在相同的id，跳过这条记录
                            }
                            idSet.add(id); // 将当前记录的id添加到Set中
                        }
                        int id = idSet.size();
                        id = id + 1;    //该数据库对应的id
                        //end id

                        //下面这部分是用来分割输入的中文表名称，以便和后续的英文名对应
                        String[] tbnames = alltbname.split(","); // 使用逗号分隔字符串
                        int index = 0;    //第一个中文名的下标为0
                        //end tbnames

                        //下面开始读取sql文件，并根据文件新建表结构
                        while (scanner.hasNext()) { //每次读取一句
                            String sql = scanner.next();
                            if (!sql.trim().isEmpty()) {
                                System.out.println(sql.trim()); // 输出当前 SQL 语句
                                Pattern pattern = Pattern.compile("CREATE\\s+TABLE\\s+IF\\s+NOT\\s+EXISTS\\s+(\\w+)");
                                Matcher matcher = pattern.matcher(sql);
                                if (matcher.find()) {
                                    String tablesname_en = matcher.group(1);    //获取到tablesname_en
//                                    System.out.println(tableName); // 输出 mytable1
                                    String tablesname = tbnames[index];
                                    index++;
                                    Databases databasestmp = new Databases(id, DBname, DBdescribe, tablesname, tablesname_en);
                                    databases_service.insertDatabases(databasestmp);
                                }
                                tableMapper.createTable(sql);
                            }//end while
                        }//end while
                        //end 读取sql文件

                        // 记录下日志
                        Log log = new Log((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()),
                                "上传数据库", userID, IPUtils.getIPAddress(request), "用户权限管理模块");
                        logService.insertLog(log);

                        result.put("msg", "文件上传成功!");
                        return result;
                    } catch (IOException e) {
                        //上传失败+原因
                        e.printStackTrace();
                        result.put("success", false);
                        result.put("msg", "上传失败：" + e.getMessage());
                        return result;
                    }
                } else {
                    //文件为空导致的上传失败
                    result.put("success", false);
                    result.put("msg", "上传失败：文件为空!");
                    return result;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return StatusCode.error(3001, "服务器内部错误：" + e.toString());
            }
        } else {
            //非法token
            return StatusCode.error(2001, "用户未登录");
        }
    }//end updateDB


}

package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Log {
    private Long id;
    private String createdAt;
    private String message;
    private String userID;
    private String ipAddress;
    private String module;
    public Log(String createdAt, String message, String userID, String ipAddress, String module) {
        this.createdAt = createdAt;
        this.message = message;
        this.userID = userID;
        this.ipAddress = ipAddress;
        this.module = module;
    }
}
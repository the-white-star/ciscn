package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data       //使用这个注解可以省去代码中大量的get()、 set()、 toString()等方法；
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)   // 忽略返回参时值为null的字段
public class Medical_Insurance {

    private String patientId;
    private String type;
    private String cardId;
    private String validper;
}


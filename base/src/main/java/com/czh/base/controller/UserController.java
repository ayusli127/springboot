package com.czh.base.controller;

import com.czh.base.exception.MyException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @RequestMapping("/index")
    public String index(){
        return dataSourceUsername;
    }
    @RequestMapping("/json")
    public String json() throws MyException{
        throw new MyException("发生错误");
    }
}

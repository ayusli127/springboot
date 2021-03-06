package com.czh.base.controller;

import com.czh.base.config.MyWebConfig;
import com.czh.base.dao.UserMapper;
import com.czh.base.domain.User;
import com.czh.base.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Value("${spring.datasource.username}")
    private String dataSourceUsername;
    @Autowired
    MyWebConfig myWebConfig;
    @RequestMapping("/index")
    public String index(){
        return "root";
    }
    @RequestMapping("/json")
    public String json() throws MyException{
        throw new MyException("发生错误");
    }
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/getUser/{id}")
    public User getUserById(@PathVariable("id") Integer id){
        return userMapper.findById(id);
    }
    @RequestMapping("/config")
    public String config(){
        return "name :" + myWebConfig.getName() + "version" + myWebConfig.getVersion() +"description:"+ myWebConfig
                .getDescription();
    }
}

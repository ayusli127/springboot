package com.czh.base.dao;

import com.czh.base.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM USER WHERE ID = #{id}")
    User findById(@Param("id") Integer id);
}

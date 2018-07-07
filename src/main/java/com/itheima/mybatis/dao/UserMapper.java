package com.itheima.mybatis.dao;

import com.itheima.mybatis.pojo.QueryVo;
import com.itheima.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    User queryUser(Integer Id) throws Exception;

    List<User> findUserByQueryVo(QueryVo queryVo) throws Exception;

    int findUserCount(User user) throws Exception;
}

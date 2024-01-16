package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;


public interface UserService {

    // 根据用户名查询用户
    User findByUserName(String username);

    // 注册
    void register(String username, String password);

    // 通过username查询所有字段,除了password
    User findByAll(String username);

    // 更新用户基本信息
    void update(User user);

    // 更新用户头像
    void updateAvatar(String avatarUrl);

    // 更新密码
    void updatePwd(String psw_new);
}

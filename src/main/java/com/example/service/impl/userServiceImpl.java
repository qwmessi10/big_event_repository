package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.Md5Util;
import com.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class userServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    // 获取线程中的用户信息
//    private Map<String, Object> getMessage() {
//        Map<String, Object> map = ThreadLocalUtil.get();
//        Integer id = (Integer) map.get("id");
//        Integer username = (Integer) map.get("username");
//
//        Map<String, Object> msg = new HashMap<>();
//        msg.put("id", id);
//        msg.put("username", username);
//        return msg;
//    }

    @Override
    public User findByUserName(String username) {
        User u = userMapper.findByUserName(username);
        return u;
    }

    @Override
    public void register(String username, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        //添加
        userMapper.add(username,md5String);
    }

    @Override
    public User findByAll(String username) {
        User u = userMapper.findByAll(username);
        return u;
    }

    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        userMapper.updateAvatar(avatarUrl, id);
    }

    @Override
    public void updatePwd(String psw_new) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        userMapper.updatePwd(psw_new, id);
    }
}

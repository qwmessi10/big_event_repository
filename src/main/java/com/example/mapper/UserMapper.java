package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 根据username查询用户
    @Select("select * from big_event.user where username=#{username}")
    User findByUserName(String username);

    //添加
    @Insert("insert into big_event.user(username,password,create_time,update_time)" +
            " values(#{username},#{password},now(),now())")
    void add(String username, String password);

    // 根据username查询除了password以外的字段
    @Select("select id, username, nickname, email, user_pic," +
            " create_time, update_time from user where username = #{username}")
    User findByAll(String username);

    // 更新用户基本信息
    @Update("update user set nickname = #{nickname}, email = #{email}, update_time = #{updateTime} where id = #{id}")
    void update(User user);

    // 更新用户头像
    @Update("update user set user_pic = #{avatarUrl}, update_time = now() where id = #{id}")
    void updateAvatar(String avatarUrl, Integer id);

    // 更新密码
    @Update("update user set password = #{psw_new}, update_time = now() where id = #{id}")
    void updatePwd(String psw_new, Integer id);
}

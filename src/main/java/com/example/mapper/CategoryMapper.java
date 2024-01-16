package com.example.mapper;

import com.example.pojo.Article;
import com.example.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    // 查询文章列表
    @Select("select * from category")
    List<Category> findList();

    // 新增文章分类
    @Insert("insert into category (category_name, category_alias, create_user, create_time, update_time)" +
            " values (#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime});")
    void add(Category category);


    // 获取文章分类详情
    @Select("select * from category where id = #{id}")
    Category getDetail(Integer id);

    // 更新文章分类
    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}, " +
            "update_time = now() where id = #{id}")
    void updateCategory(Category category);

    // 删除文章分类
    @Delete("delete from category where id = #{id}")
    void deleteCateGory(Integer id);
}

package com.example.mapper;

import com.example.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

    // 添加文章
    @Insert("insert into article (title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
            " values (#{title}, #{content}, #{coverImg},#{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    // 更新文章
    @Update("update big_event.article set title = #{title}, content = #{content}, cover_img = #{coverImg}, " +
            "state = #{state}, category_id = #{categoryId}, update_time = now()")
    void update(Article article);

    // 获取文章详情
    @Select("select * from article where id = #{id}")
    Article getArticle(Integer id);

    // 删除文章
    @Delete("delete from article where id = #{id}")
    void deleteArticle(Integer id);

    //分页查询
    List<Article> list(Integer cateGoryId, String state, Integer userId);
}

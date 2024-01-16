package com.example.service;

import com.example.pojo.Article;
import com.example.pojo.pageBean;

public interface ArticleService {

    // 新增文章
    void add(Article article);

    // 更新文章
    void updateArticle(Article article);

    // 获取文章详情
    Article getArticle(Integer id);

    // 删除文章
    void deleteArticle(Integer id);

    // 分页查询
    pageBean<Article> list(Integer pageNum, Integer pageSize, Integer cateGoryId, String state);
}

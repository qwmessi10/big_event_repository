package com.example.service;

import com.example.pojo.Article;
import com.example.pojo.Category;

import java.util.List;
import java.util.Map;

public interface categoryService {

    // 获取文章列表
    List<Category> findByCategory();

    // 新增文章分类
    void add(Category category);

    // 获取文章分类详情
    Category getDetail(Integer id);

    // 更新文章分类
    void updateCategory(Category category);

    // 删除文章分类
    void deleteCategory(Integer id);
}

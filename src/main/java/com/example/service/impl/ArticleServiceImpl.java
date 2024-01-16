package com.example.service.impl;

import com.example.mapper.ArticleMapper;
import com.example.pojo.Article;
import com.example.pojo.pageBean;
import com.example.service.ArticleService;
import com.example.utils.AliOssUtil;
import com.example.utils.ThreadLocalUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer UserId = (Integer) map.get("id");

        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());
        article.setCreateUser(UserId);

        articleMapper.add(article);
    }

    @Override
    public void updateArticle(Article article) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        article.setCreateUser(userId);
        article.setUpdateTime(LocalDateTime.now());

        articleMapper.update(article);
    }

    @Override
    public Article getArticle(Integer id) {
        Article article = articleMapper.getArticle(id);

        return article;
    }

    @Override
    public void deleteArticle(Integer id) {
        articleMapper.deleteArticle(id);
    }

    @Override
    public pageBean<Article> list(Integer pageNum, Integer pageSize, Integer cateGoryId, String state) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        // 创建pageBean对象
        pageBean<Article> pb = new pageBean<>();

        // 开启分页查询
        PageHelper.startPage(pageNum, pageSize);

        // 调用mapper查询
        List<Article> as = articleMapper.list(cateGoryId, state, userId);
        Page<Article> p = (Page<Article>) as;

        // ----------------------------------------------------------------
        // 把数据填充到pageBean对象中
        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        System.out.println(pb);
        return pb;
    }
}

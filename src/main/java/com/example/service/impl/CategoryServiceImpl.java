package com.example.service.impl;

import com.example.mapper.CategoryMapper;
import com.example.pojo.Article;
import com.example.pojo.Category;
import com.example.service.categoryService;
import com.example.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements categoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findByCategory() {
        List<Category> list = categoryMapper.findList();
        return list;
    }

    @Override
    public void add(Category category) {
        // 补充属性值
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        category.setCreateUser(userId);
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        categoryMapper.add(category);
    }

    @Override
    public Category getDetail(Integer id) {
        Category category =  categoryMapper.getDetail(id);

        return category;
    }

    @Override
    public void updateCategory(Category category) {
        categoryMapper.updateCategory(category);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryMapper.deleteCateGory(id);
    }
}

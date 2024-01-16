package com.example.controller;

import com.example.pojo.Article;
import com.example.pojo.Category;
import com.example.pojo.Result;
import com.example.service.categoryService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private categoryService categoryService;

    // 获取文章分类列表
    @GetMapping
    public Result list() {
        List<Category> list = categoryService.findByCategory();

        return Result.success(list);
    }

    // 新增文章分类
    @PostMapping
    public Result add(@RequestBody @Validated Category category) {
        categoryService.add(category);

        return Result.success();
    }

    // 获取文章分类详情
    @GetMapping("detail")
    public Result getListDetail(@RequestParam Integer id) {
        Category category = categoryService.getDetail(id);
        return Result.success(category);
    }

    // 更新文章分类
    @PutMapping
    public Result updateCategory(@RequestBody @Validated Category category) {
        categoryService.updateCategory(category);

        return Result.success();
    }

    // 2.5 删除文章分类
    @DeleteMapping
    public Result deleteCategory(@RequestParam Integer id) {
        categoryService.deleteCategory(id);

        return Result.success();
    }

}

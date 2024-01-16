package com.example.controller;

import com.example.pojo.Article;
import com.example.pojo.Result;
import com.example.pojo.pageBean;
import com.example.service.ArticleService;
import com.example.utils.AliOssUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    // 3.1 发布文章
    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
//        // 获取原始的文件名
//        String originalFilename = file.getOriginalFilename();
//        // 构造唯一的文件名
//        String extName = UUID.randomUUID().toString().substring(originalFilename.lastIndexOf("."));
//        // extName是生成的UUID, originalFilename是文件名称和后缀
//        String fileName = extName + originalFilename;
//
//        String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
//
//        article.setCoverImg(url);

        articleService.add(article);

        return Result.success();
    }

    // 3.2 更新文章
    @PutMapping
    public Result updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);

        return Result.success();
    }

    // 3.3 获取文章信息
    @GetMapping("/detail")
    public Result getArticle(@RequestParam Integer id) {
        Article article = articleService.getArticle(id);

        return Result.success(article);
    }

    // 3.4 删除文章
    @DeleteMapping
    public Result deleteArticle(@RequestParam Integer id) {
        articleService.deleteArticle(id);

        return Result.success();
    }

    // 3.5文章列表条件分页
    @GetMapping
    public Result<pageBean<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        pageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);

        return Result.success(pb);
    }


}

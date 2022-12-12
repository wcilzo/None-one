package com.experiment.article.Controller;

import com.experiment.article.Entity.Article;
import com.experiment.article.Entity.User;
import com.experiment.article.Service.ArticleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/article")
public class articleController {
    @Resource
    ArticleService articleService;
    @RequestMapping("/getAllArticles")
    public List<Article> getAllArticles(){
        return articleService.getAllArticle();
    }
}

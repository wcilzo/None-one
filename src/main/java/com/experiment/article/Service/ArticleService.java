package com.experiment.article.Service;


import com.experiment.article.Dao.ArticleMapper;
import com.experiment.article.Entity.Article;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {
    @Resource
    ArticleMapper articleMapper;

    public List<Article> getAllArticle(){
       return articleMapper.selectList(null);
    }
}

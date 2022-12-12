package com.experiment.article.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.experiment.article.Entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ArticleMapper extends BaseMapper<Article> {

}

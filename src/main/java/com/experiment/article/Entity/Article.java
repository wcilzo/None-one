package com.experiment.article.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor


@TableName("article")
public class Article {
    private Integer id;
    private String author;
    private String title;
    private String content;
//    数据库里面的字段DataTime和Java类型Data要映射
//    private Date creatTime;

}

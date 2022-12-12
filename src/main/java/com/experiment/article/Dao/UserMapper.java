package com.experiment.article.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.experiment.article.Entity.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
//注册的都默认普通用户，管理员用户就两个admin和HaQi
//    @Insert("insert into `user`(`username`,`password`,`role`) VALUES (#{username},#{password},`user`)")
//    @Transactional
//    int insert(User user);

//
    @Select("select * from user where username=#{username}")
     User findUser(String username);


}

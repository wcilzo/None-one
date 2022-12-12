package com.experiment.article.Controller;

import com.experiment.article.Entity.User;
import com.experiment.article.Service.UserService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
   @Resource
   UserService userService;

//  注册，并跳转到登录页面
    @PostMapping("/register")
    public String addUser(String username,String password){
       return userService.addUser(username, password);
    }

//    登陆，并把user存到Session里，共拦截器判断
    @PostMapping("/login")
    public String getUser(HttpServletRequest request, String username, String password) throws Exception {

        return userService.getUser(request,username, password);

    }

    //退出登陆状态,清除Session,重定向到Home.html
    @RequestMapping("/logout")
    public void logout(HttpSession session, SessionStatus sessionStatus){

    }

//    由于加了拦截器，这个方法只有role为管理员才可以调用,获取所有用户的集合
    @RequestMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }
}

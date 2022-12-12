package com.experiment.article.Service;

import com.experiment.article.Dao.UserMapper;
import com.experiment.article.Entity.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;


    public String addUser(String username,String password){

        User user = userMapper.findUser(username);

        if (user!=null){
            return "用户已存在";
        }
        if (username==null){
            return "用户名为空";
        }
        if (password==null||password.length()<6){
            return "密码为空或密码位数小于6";
        }
        userMapper.insert(new User(username,password,null));

        return "Success";

    }


    public String getUser(HttpServletRequest request, String username, String password) throws Exception {

        User user = userMapper.findUser(username);
        System.out.println(user);
        //有配置异常处理器，但是我还没自定义异常，先用父类测试，或者干脆就返回错误信息给前端
        if( user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//            throw new Exception("用户名不存在");
            return "用户名不存在";
        }
        if(!password.equals(user.getPassword())){
//            throw new PasswordNotException("密码错误");
//            throw new Exception("密码错误");
            return "密码错误";
        }
        request.getSession().setAttribute("user",user);
        return "Success";

    }


    public List<User> getAllUser(){
       return userMapper.selectList(null);
    }
}

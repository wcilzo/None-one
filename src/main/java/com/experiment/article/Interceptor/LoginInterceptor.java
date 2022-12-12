package com.experiment.article.Interceptor;

import com.experiment.article.Entity.User;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前session
        HttpSession session = request.getSession();
        // 根据session获取登录用户
        User user = (User)session.getAttribute("user");
//        System.out.println(user);
        // 没登录，重定向到登录页面
        if (user==null) {
            response.sendRedirect(request.getContextPath() + "/Login.html");
            return false;
        }
        // 已经登录
        return true;
    }
}
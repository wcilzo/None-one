package com.experiment.article.Interceptor;

import com.experiment.article.Entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class AdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取当前session
        HttpSession session = request.getSession();
        // 根据session获取登录用户
        User user = (User)session.getAttribute("user");
//        System.out.println(user);
        // 没登录，重定向到登录页面
//        if (user==null) {
//            response.sendRedirect(request.getContextPath() + "/Login.html");
//            return false;
//        }
//        权限不是管理员,无效
        if (!Objects.equals(user.getRole(), "admin")) {
            response.sendRedirect(request.getContextPath() + "/user/Index.html");
            return false;
        }
        // 已经登陆且权限是管理员
        return true;
    }
}

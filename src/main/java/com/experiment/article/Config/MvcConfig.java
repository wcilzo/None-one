package com.experiment.article.Config;

import com.experiment.article.Interceptor.AdminInterceptor;
import com.experiment.article.Interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
//在这里实现对SpringMvc的自定义

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截规则：只拦截前端user下的目录
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 排除拦截
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user/**").
        excludePathPatterns("/**");
        registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/admin/**").
        excludePathPatterns("/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:Home.html");


    }

}

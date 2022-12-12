package com.experiment.article.ExceptionResolver;


import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//异常解析器


//@Component
//还没有自定义异常，就先不开启统一的异常处理
class Resolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //如果因为某些异常想跳转页面，用ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof IOException) {
        //对应处理异常的逻辑
            System.out.println("IOException");
        }else if (ex instanceof NullPointerException) {
            System.out.println("NullPointerException");
        }else if (ex instanceof ArithmeticException){
            System.out.println("ArithmeticException");
        } else {
            System.out.println("Exception");
        }

        return modelAndView;
    }
}

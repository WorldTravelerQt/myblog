package com.scxh.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 乔童
 * @Description: 全局异常处理
 * @Date: 2020/02/21 11:06
 * @Version: 1.0
 */
@ControllerAdvice
public class ControllerExceptionHandlerInterceptor {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    /**
     * 处理异常信息
     * @return 错误页面
     * @ExceptionHandler 标识这个方法是做异常处理的
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        //添加错误日志
        logger.error("Request URL :{}\nException:{}",req.getRequestURL(),e.toString());
        //通过注解工具类去查找这个异常是否存在响应状态码注解，如果存在，抛出这个异常，让springboot去处理它
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class)!=null)
        {
            throw e;
        }
        //添加错误对象信息
        ModelAndView mav=new ModelAndView();
        mav.addObject("url",req.getRequestURL());
        mav.addObject("exception",e);
        //设置跳转到自定义错误页面
        mav.setViewName("error/error");
        return mav;
    }
}

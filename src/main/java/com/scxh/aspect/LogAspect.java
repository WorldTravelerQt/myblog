package com.scxh.aspect;

import com.scxh.controller.ErrorEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: 乔童
 * @Description: 日志切面
 * 所需记录的内容：
 * 	请求url
 * 	访问者ip
 * 	调用方法classMethod
 * 	参数args
 *  返回内容
 * @Date: 2020/02/21 15:34
 * @Version: 1.0
 */
@Component
@Aspect
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* *.*.controller.*.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint point)
    {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //判断attributes是否为null，通常来说不可能为null
        if(attributes==null)
        {
            throw new RuntimeException(ErrorEnum.SYSTEM_ERROR.getMessage());
        }
        HttpServletRequest request = attributes.getRequest();
        String ip=request.getRemoteAddr();
        String url=request.getRequestURL().toString();
        Object[] args= point.getArgs();
        /*
            getDeclaringTypeName()方法获取类名
            getName()方法获取方法名
         */
        String method=point.getSignature().getDeclaringTypeName()+"."+point.getSignature().getName()+"()";
        logger.info("{}",new RequestLog(ip,url,args,method));
    }
    @AfterReturning(returning = "value",value = "log()")
    public void doAfterReturning(Object value)
    {
        logger.info("Result：{}",value);
    }

    /**
     * 请求日志内部类
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class RequestLog{
        private String ip;
        private String url;
        private Object[] args;
        private String method;

        @Override
        public String toString() {
            return "请求日志{" +
                    "请求ip地址='" + ip + '\'' +
                    ", 请求地址='" + url + '\'' +
                    ", 请求参数='" + Arrays.toString(args) + '\'' +
                    ", 请求方法='" + method + '\'' +
                    '}';
        }
    }
}

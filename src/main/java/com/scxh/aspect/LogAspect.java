package com.scxh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: 乔童
 * @Description: 日志切面
 * @Date: 2020/02/21 15:34
 * @Version: 1.0
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* *.*.controller.*.*(..))")
    public void log(){}

    /**
     * 环绕通知
     * @param point
     * @return
     */
    @Around("log()")
    public Object around(ProceedingJoinPoint point)
    {
        Object value=null;
        try {
            System.out.println("doBefore");
            value=point.proceed();
            System.out.println("doAfter()");
            logger.info("Result：{}",value);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return value;
    }
}

package com.bookServer.config;

import com.bookServer.exception.CustomException;
import com.bookServer.util.RestfulEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ApiAop {

//    @Around(value = "execution(* com.bookServer.facade.*.controller..*.*(..)) || execution(* cn.com.cloudpioneer.permission.controller..*.*(..))")
    @Around(value = "execution(* com.bookServer.facade.*.controller..*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return new RestfulEntity(true, 200, pjp.proceed());
        } catch (CustomException e) {
            return new RestfulEntity(false, e.getCode(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return new RestfulEntity(false, 202, e.getMessage());
        }
    }
}

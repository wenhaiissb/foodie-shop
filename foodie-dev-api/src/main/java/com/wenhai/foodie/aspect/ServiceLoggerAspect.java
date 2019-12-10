package com.wenhai.foodie.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class ServiceLoggerAspect {
    @Around("execution(* com.wenhai.foodie.service.impl..*.*(..))")
    public Object recordTimeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===========开始执行{}.{}===========", joinPoint.getTarget().getClass(), joinPoint.getSignature().getName());
        Long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        Long takeTime = end - start;
        if (takeTime > 3000) {
            log.error("=======执行结束，耗时：{} 毫秒===========", takeTime);
        } else if (takeTime > 2000) {
            log.warn("=======执行结束，耗时：{} 毫秒===========", takeTime);
        } else {
            log.info("=======执行结束，耗时：{} 毫秒===========", takeTime);
        }
        return result;
    }
}

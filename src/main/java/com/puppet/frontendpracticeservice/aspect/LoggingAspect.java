package com.puppet.frontendpracticeservice.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.puppet.frontendpracticeservice.controller.*.*(..)) ||" +
            " execution(* com.puppet.frontendpracticeservice.service.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logBefore(JoinPoint joinPoint) {
        String typeClass = joinPoint.getTarget().getClass().isAnnotationPresent(Service.class) ?
                "сервис" : "контроллер";
        log.info("Вызван {}: {} c аргументами: {}", typeClass, joinPoint.getSignature(), Arrays.toString(joinPoint.getArgs()));
    }

    @Around("pointCut()")
    public Object LogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        Object[] args = joinPoint.getArgs();

        if (log.isDebugEnabled()) {
            log.debug("Вызван метод {}.{} с аргументами: ({})", className, methodName, Arrays.toString(args));
        }

        Object result = joinPoint.proceed();
        if (log.isDebugEnabled()) {
            log.debug("Метод {} вернул результат: {}", methodName, result);
        }
        return result;
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("Исключение в {}.{}() с причиной = {} - ({})",
                joinPoint.getSignature().getName(),
                joinPoint.getTarget().getClass().getSimpleName(),
                e.getClass().getSimpleName(),
                e.getMessage());
    }
}

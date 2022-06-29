package com.library.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookAspect {
    @After("execution(* com.library.controller.BookController.borrowBook(..))")
    public void logAfterMethodController(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        System.err.println("The method just called is:" + method);
    }

    private int countVisitor = 0;

    @Pointcut("within(com.library.controller.BookController*)")
    public void allControllerPointCut() {
    }

    @After("allControllerPointCut()")
    public void countVisitor() {
        System.out.println("------------------");
        System.err.println("The number of visitor = " + ++countVisitor);
    }
}
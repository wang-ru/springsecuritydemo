package wr.security.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

//@Aspect
//@Component
public class TimeAspect {
    @Around("execution(* wr.security.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        Long startTime = new Date().getTime();
        System.out.println("TimeAspect start");
        Arrays.stream(pjp.getArgs()).forEach(e->{
            System.out.println(e);
        });
        Object proceed = pjp.proceed();
        System.out.println("TimeAspect end :"+ (new Date().getTime()-startTime));
        return proceed;
    }
}

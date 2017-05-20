package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.zerock.util.DbContextHolder;
import org.zerock.util.DbType;

@Component
@Aspect
public class SampleAdvice {

  private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);

  //@Before("execution(* org.zerock.service.**.*(..))")
  public void startLog(JoinPoint jp) {

    logger.info("----------------------------");
    logger.info("----------------------------");
    logger.info(Arrays.toString(jp.getArgs()));

  }
  
  
  @Around("execution(* org.zerock.service.**.*(..))")
  public Object timeLog(ProceedingJoinPoint pjp)throws Throwable{
    
    long startTime = System.currentTimeMillis();
    logger.info(Arrays.toString(pjp.getArgs()));

    DbContextHolder.setDbType(DbType.REPLICA1);
    Object result = pjp.proceed();
    
    long endTime = System.currentTimeMillis();
    logger.info( pjp.getSignature().getName()+ " : " + (endTime - startTime) );
    logger.info("=============================================");
    
    return result;
  }   

}
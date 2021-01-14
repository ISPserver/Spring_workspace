package com.koreait.fashionshop.client.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.koreait.fashionshop.exception.LoginRequiredException;


public class MemberSessionCheckAspect {
   private static final Logger logger = LoggerFactory.getLogger(MemberSessionCheckAspect.class);
   
   public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
      Object result = null;
      Object target = joinPoint.getTarget();
      logger.debug("target : " + target);
      String methodName = joinPoint.getSignature().getName();
      
      logger.debug("methodName : " + methodName);
      
      HttpServletRequest request = null;
      
      Object [] args = joinPoint.getArgs();
      for(Object arg : args) {
         logger.debug("arg : " + arg);
         if(arg instanceof HttpServletRequest) {
            request = (HttpServletRequest)arg;
         }
      }
      
      HttpSession session = request.getSession();
      
      if(session.getAttribute("member") == null) {
         throw new LoginRequiredException("로그인이 필요한 서비스입니다");
      } else {
         result = joinPoint.proceed();
      }
      
      return result;
   }
}
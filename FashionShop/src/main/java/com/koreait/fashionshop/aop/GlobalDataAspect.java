package com.koreait.fashionshop.aop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.model.product.service.TopCategoryService;

/*
 * 쇼핑몰 이용시 전반적으로 사용할 카테고리 메뉴 목록
 * */
public class GlobalDataAspect {
	@Autowired
	private TopCategoryService topCategoryService;
	
	public Object getGlobalData(ProceedingJoinPoint joinPoint) throws Throwable{
		Object result=null;
		HttpServletRequest request;
		
		//매개변수로부터 요청 객체 추출!!
		for(Object arg : joinPoint.getArgs()) {
			if(arg instanceof HttpServletRequest) {
				request = (HttpServletRequest)arg;
			}
		}
		
		//topList 가져오기
		List topList = topCategoryService.selectAll();
		Object returnObj = joinPoint.proceed();//원래 호출하려 했던 메서드호출
		ModelAndView mav = null;
		if( returnObj instanceof ModelAndView) {
			mav =(ModelAndView)returnObj;
			mav.addObject("topList",topList);
			result=mav;
		}
		return result;
	}
}
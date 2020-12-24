package com.study.springfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*갈수록, 시스템 의존하지 않는 POJO가 목표
Plain Old Java Object 추구함(옛날 java)*/
@Controller
public class TestController {
	
	//어떤 url에 반응할지 즉 어떤 요청 처리할지 결정
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public ModelAndView test() {
		ModelAndView mav = new ModelAndView("test/result");//setViewName과 동일
		return mav;
	}
}

package com.koreait.mvclegacy.controller.admin;
//�����ڱ�ɰ� ���õ� ��� ��û�� ó���ϴ� ��Ʈ�ѷ�

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.mvclegacy.model.member.MemberService;

@Controller
public class AdminController {
	//All < DEBUG < INFO < WARN < ERROR < FATAL < OFF
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="/main",  method=RequestMethod.GET)
	public String test() {
		logger.debug("test() ȣ��");
		logger.debug("admin Service:"+memberService);
		memberService.regist();
		return null;
	}
		
}
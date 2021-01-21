package com.koreait.restproject.rest.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.koreait.restproject.model.domain.Member;
import com.koreait.restproject.model.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@RestController //Controller에 ResponseBody가 탑재된 컨트롤러
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member")
	@ResponseBody
	public String getList() {
		log.debug("리스트 요청");
		return "Hello";
	}	
	
	@PostMapping("/member")
	public String regist(@RequestBody Member member) {
		log.debug("Are u want regist?");
		log.debug("m_id: "+member.getM_id());
		log.debug("m_pass: "+member.getM_pass());
		log.debug("m_name: "+member.getM_name());
		
		memberService.regist(member);
		
		return "regist success";//REST에서는 개발자가 클라이언트에게 뭘 반환해야 할까?
	}
}

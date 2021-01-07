package com.koreait.fashionshop.model.member.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberService {
	public List selectAll(); //모든 회원가져오기
	public Member select(Member member); //회원 1명 가져오기
	public void regist(Member member); //회원등록 및 기타필요사항 처리
	public void update(Member member);//회원등록 수정
	public void delete(Member member);//회원정보 삭제(primary뿐 아니라 id,pass일치시 삭제 위해 Member 매개변수)
}

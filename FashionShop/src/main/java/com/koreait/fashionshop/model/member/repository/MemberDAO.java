package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {
	public List selectAll(); //모든 회원가져오기
	public Member select(); //회원 1명 가져오기
	public void insert(Member member); //회원등록
	public void update(Member member);//회원등록 수정
	public void delete(Member member);//회원정보 삭제(primary뿐 아니라 id,pass일치시 삭제 위해 Member 매개변수)
	
}

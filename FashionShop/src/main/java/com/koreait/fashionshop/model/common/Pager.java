/*Paging 처리를 재사용성을 높이는 클래스 정의*/
package com.koreait.fashionshop.model.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Pager {
	private List list;
	private int totalRecord; //총 레코드 수
	private int pageSize= 10;//페이지당 보여질 레코드 수
	private int totalPage;
	private int blockSize=10; //블럭당 보여질 페이지 수
	private int currentPage =1;	
	private int firstPage;
	private int lastPage;
	private int curPos;//페이지당 List 내에서의 시작 index (커서)
	private int num; //페이지당 시작 번호
	
	//선언된 변수 초기화
	public void init(HttpServletRequest request, List list) {
		this.list=list;
		totalRecord = list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);		
		
		//페이지를 선택한 경우엔, 그 선택된 페이지로 대체
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage-(currentPage-1)%blockSize;
		lastPage = firstPage+(blockSize-1);
		curPos = (currentPage-1)*pageSize;
		num = totalRecord - curPos;
		
	}

	
	
}

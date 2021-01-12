/*Paging ó���� ���뼺�� ���̴� Ŭ���� ����*/
package com.koreait.fashionshop.model.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class Pager {
	private List list;
	private int totalRecord; //�� ���ڵ� ��
	private int pageSize= 10;//�������� ������ ���ڵ� ��
	private int totalPage;
	private int blockSize=10; //���� ������ ������ ��
	private int currentPage =1;	
	private int firstPage;
	private int lastPage;
	private int curPos;//�������� List �������� ���� index (Ŀ��)
	private int num; //�������� ���� ��ȣ
	
	//����� ���� �ʱ�ȭ
	public void init(HttpServletRequest request, List list) {
		this.list=list;
		totalRecord = list.size();
		totalPage = (int)Math.ceil((float)totalRecord/pageSize);		
		
		//�������� ������ ��쿣, �� ���õ� �������� ��ü
		if(request.getParameter("currentPage")!=null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage-(currentPage-1)%blockSize;
		lastPage = firstPage+(blockSize-1);
		curPos = (currentPage-1)*pageSize;
		num = totalRecord - curPos;
		
	}

	
	
}

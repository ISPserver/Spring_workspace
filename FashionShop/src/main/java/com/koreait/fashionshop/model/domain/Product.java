package com.koreait.fashionshop.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data 
public class Product {
	private int product_id;
	private int subcategory_id;
	private String product_name;
	private int price;
	private String brand;
	private String detail;
	private String filename; //currentTimeMills�� �Ұ���
	
	//�̹��� �ϳ��� �ڵ����� ó���ϴ� ��ü ���� 
	//��, �̸��� html�� ���ε� ������Ʈ �Ķ���͸��� ��ġ���Ѿ� �ڵ����� ���ε� ó��..
	private MultipartFile repImg;	//��ǥ�̹��� 
	private MultipartFile[] addImg; //�߰� �̹����� ���û����̸�, ���ÿ� �迭
		
	private Color[] color;//���󰪵�
	private Psize[] psize;//������
}
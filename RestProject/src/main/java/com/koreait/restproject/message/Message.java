package com.koreait.restproject.message;

import lombok.Data;

@Data
public class Message {
	private String msg;//클라이언트가 받게될 에러 메시지
	private int statusCode;//http 상태코드 200,404,500,403
	
	
}

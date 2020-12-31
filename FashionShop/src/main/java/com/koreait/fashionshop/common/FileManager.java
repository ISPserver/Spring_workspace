package com.koreait.fashionshop.common;

import java.io.File;

public class FileManager {
	private String saveDir;
	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}
	
	public String getSaveDir() {
		return saveDir;
	}
	
	//확장자만 추출하기
	public static String getExtend(String path) {
		int start = path.lastIndexOf(".");
		int end = path.length();
		String ext = path.substring(start+1, end);
		
		return ext;
	}
	
	//파일 삭제( 호출자는 삭제 원하는 파일 경로 넘기기)
	public static boolean deleteFile(String path) {
		File file = new File(path);		
		return file.delete();
	}
	/*
	//단위테스트 해보기 위함
	public static void main(String[] args) {
		String filename="c:\\photo\\summer\\2010\\지난여름.사진.jpg";
		System.out.println(getExtend(filename));
	}
	*/
}

package com.koreait.fashionshop.model.common;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
@Component /* component-scan�� ��� �� �ϳ�*/
public class FileManager {
	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
	private String saveBasicDir="/resources/data/basic";
	private String saveAddonDir="/resources/data/addon";
	
	//Ȯ���ڸ� �����ϱ�
	public static String getExtend(String path) {
		int start = path.lastIndexOf(".");
		int end = path.length();
		String ext = path.substring(start+1, end);
		
		return ext;
	}
	
	//���� ����( ȣ���ڴ� ���� ���ϴ� ���� ��� �ѱ��)
	public static boolean deleteFile(String path) {
		File file = new File(path);		
		return file.delete();
	}
	
	//���� �����ϱ�
	public void saveFile(String realDir, MultipartFile multi) {
		try {
			multi.transferTo(new File(realDir));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

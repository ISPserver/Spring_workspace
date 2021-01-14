package com.koreait.fashionshop.model.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.SubCategory;

/*
 * �� ������ �о�鿩, �ڹ��� POJO���·� ��ȯ�ϴ� �뵵
 * */
@Component //scan�� ����� ��
public class ProductConverter {
	
	//������ �� �޼��带 ȣ���ϴ� �ڴ�, �ڽ��� ������ ��Ʈ�� �ּҸ� �ѱ�� ��
	public List convertFromFile(String path) {	
		List<Product> productList = new ArrayList<Product>();
		
		//�������� ���� ��ü ����
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
			XSSFWorkbook book = new XSSFWorkbook(fis);
			
			//������ ����������, ��Ʈ�� �����غ���
			XSSFSheet sheet =  book.getSheetAt(0); //ù��° ��Ʈ�� ����
			
			//���� �ݺ����� Ƚ�� ���ϱ�
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			for(int i=1; i<rowCount; i++) {
				Product product = new Product(); //�ֺ� VO �غ�(ä���ֱ� ����)
				//�÷�����ŭ �ݺ��� ó��
				XSSFRow row = sheet.getRow(i);//�� �ϳ� ��� 
				for(int a=0; a<row.getPhysicalNumberOfCells(); a++) {
					XSSFCell cell = row.getCell(a); //�� �ϳ��� ����
					
					if(a==0) { //subcategory_id
						SubCategory subCategory = new SubCategory();
						subCategory.setSubcategory_id((int)cell.getNumericCellValue());
						product.setSubCategory(subCategory);
					}else if(a==1) {//product_name
						product.setProduct_name(cell.getStringCellValue());
					}else if(a==2) {
						product.setPrice((int)cell.getNumericCellValue());						
					}else if(a==3) {
						product.setBrand(cell.getStringCellValue());
					}else if(a==4) {//����
						String[] colors = cell.getStringCellValue().split(",");// ,�������� ���ø�
						List colorList = new ArrayList();
						for(String color : colors) {
							Color obj = new Color();
							obj.setPicker(color); //�ϳ��� ����VO�� �������� ����
							colorList.add(obj);
						}
						product.setColorList(colorList);
					}
					else if(a==6) {
						product.setDetail(cell.getStringCellValue());
					}
				}
				//�ϼ��� ��ǰ�� ����Ʈ�� ���
				productList.add(product);
			}			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return productList;
	}
}

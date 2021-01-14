package com.koreait.fashionshop.model.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	FileInputStream fis;
	
	public ExcelManager() {
		//ë¡œì»¬?˜ ?ŒŒ?¼?„ ? ‘ê·¼í•˜ê¸? ?œ„?•´?„œ?Š” ?ŒŒ?¼ ?Š¤?Š¸ë¦¼ì´ ?•„?š”?•¨
		try {
			fis = new FileInputStream("C:/spring_workspace/FashionShopNew/src/main/webapp/resources/excel/myskill.xlsx");
			//?—‘???„ ? œ?–´?•˜?Š” ê°ì²´ ?ƒ?„± XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//?ŒŒ?¼? ‘ê·¼ì? ?„±ê³µí•œ ?ƒ?ƒœ?´ë¯?ë¡?, ?´ ?‹œ? ë¶??„°?Š” ?‰¬?Š¸?— ? ‘ê·¼í•œ?‹¤ 
			XSSFSheet sheet=workbook.getSheetAt(0); //ì²«ë²ˆì§? ?‰¬?Š¸ ?„ ?ƒ
			
			//?´ ?‹œ? ë¶??„°?Š” sheetë¥? ? œ?–´?•  ?ˆ˜ ?ˆ?œ¼ë¯?ë¡?, ì´? ëª‡ê±´?´ ì¡´ì¬?•˜?Š”ì§?ë¶??„° ?•Œ?•„ë³¸ë‹¤ 
			int rows = sheet.getPhysicalNumberOfRows(); //?°?´?„°ê°? ì±„ì›Œì§? row ?ˆ˜
			System.out.println("? ˆì½”ë“œ ?ˆ˜?Š” : "+rows);
			
			//ë¡œìš°?? ì»¬ëŸ¼ ?ˆ˜ë§Œí¼ ë°˜ë³µë¬? ?‹¤?–‰?•˜ë©?, ?°?´?„°ë¥? ? œ?–´?•´ë³´ì
			for(int i=0;i<rows;i++) {
				XSSFRow row=sheet.getRow(i); //?•˜?‚˜?˜ ë¡œìš°ë¥? ? ‘ê·?
				
				//ì»¬ëŸ¼?ˆ˜ë§Œí¼ ë°˜ë³µë¬? ?‹¤?–‰
				int columCount=row.getPhysicalNumberOfCells();
				for(int a=0;a<columCount;a++) {
					XSSFCell cell=row.getCell(a); //ì»¬ëŸ¼ ?•œê°œë?? ? ‘ê·?
					
					//ê°ì??˜ ?ë£Œí˜•?„ ?Œ?‹¨?•˜?—¬ ê·¸ì— ë§ê²Œ ? ‘ê·? 
					if(cell.getCellType() == CellType.STRING ) {//???˜ ?ë£Œí˜•?´ ë¬¸ì?¸ê²½ìš°..
						System.out.print(cell.getStringCellValue()+"\t");
					}else if(cell.getCellType() == CellType.NUMERIC) {
						System.out.print((int)cell.getNumericCellValue()+"\t");
					}
				}
				System.out.println();//ì¤„ë°”ê¿?
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new ExcelManager();
	}

}

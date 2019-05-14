package com.web.windowHandleCheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class test3 {
	
	public static WebDriver driver;
	public static void main(String[] args) throws IOException {
		FileInputStream fi=new FileInputStream(new File(".\\imp\\TestData.xlsx"));
		Workbook wb=new XSSFWorkbook(fi);
		Sheet s=wb.getSheetAt(0);
		int rc=s.getLastRowNum()-s.getFirstRowNum();
		for(int i=0; i<rc; i++) {
			Row r=s.getRow(i);
			int cc=r.getLastCellNum();
			for (int j=0; j<cc; j++) 
				System.out.println(r.getCell(j).getStringCellValue());;		}
	}
}
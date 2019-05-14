package com.web.windowHandleCheck;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test4 {
	static int m=1;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fi=new FileInputStream(new File(".\\imp\\TestData.xlsx"));
		Workbook wb=new XSSFWorkbook(fi);
		Sheet s=wb.getSheetAt(0);
		int rc=s.getLastRowNum()-s.getFirstRowNum();
		Row rb=s.getRow(0);
		Row nr=s.createRow(rc+1);
		int cc=rb.getLastCellNum();
		for(int j=0; j<cc; j++ ) {
			Cell c=nr.createCell(j);
			c.setCellValue(m);
			m=m+1;
		}
		fi.close();
		FileOutputStream fos=new FileOutputStream(".\\imp\\TestData.xlsx");
		wb.write(fos);
		fos.close();
	}
}

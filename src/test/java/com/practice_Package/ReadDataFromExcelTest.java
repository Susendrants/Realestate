package com.practice_Package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Sheet1");
	int row = sh.getLastRowNum();
	int cell = sh.getRow(0).getLastCellNum();
	 for(int i=0; i<=row;i++)
	 {
		 for(int j=0;j<cell; j++)
		 {
			String value = sh.getRow(i).getCell(j).getStringCellValue();
			System.out.print(value);
			System.out.print("  ");
		 }
		 System.out.println();
	 }
	 
	 
	
}
}

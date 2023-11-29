package com.TestNG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.realestate.GenericUtils.ExcelUtils;

public class DataProvidersExcelTest {
@DataProvider
public Object[][] excelData() throws Throwable
{
	FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet("Sheet1");
	int row=sh.getPhysicalNumberOfRows();
	int cellcount=sh.getRow(0).getLastCellNum();
	
	Object[][] obj=new Object[row][cellcount];
	
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<cellcount;j++)
		{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
	
}

@DataProvider
public Object[][] DataExcelUtiles() throws Throwable
{
	ExcelUtils eLib=new ExcelUtils();
	Object[][] e = eLib.excelData("sheet1");
	return e;
}


}

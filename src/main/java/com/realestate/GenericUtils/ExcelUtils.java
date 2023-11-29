package com.realestate.GenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtils{
	/**
	 * This method is used to read data from excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcel(String sheetName,int row, int cell) throws Throwable
	{
		FileInputStream fi= new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		String value = sh.getRow(row).getCell(cell).getStringCellValue();
		
		return value;
	}
	/**
	 * This method is used to get the total row count
	 * @param sheetNmae
	 * @return
	 * @throws Throwable
	 */
	public int getLastRowNum(String sheetNmae) throws Throwable
	{
		FileInputStream fi= new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetNmae);
		int count=sh.getLastRowNum();
		return count;
	}
	/**
	 * This method is used to write data into excel
	 * @param sheetName
	 * @param row
	 * @param cell
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws Throwable
	{
		FileInputStream fi=new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		sh.createRow(row).createCell(cell).setCellValue(data);
		FileOutputStream fout=new FileOutputStream(IpathConstants.Excelpath);
		wb.write(fout);
		wb.close();
		
	}
	public HashMap<String,String> readMultipleData(String sheetName, WebDriver driver) throws Throwable
	
	{
		JavaUtils jLib=new JavaUtils();
		FileInputStream fi= new FileInputStream(IpathConstants.Excelpath);
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for ( int i=0;i<=count;i++)
		{
			
			
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
			
		}
		return map;
	/*	for(Entry<String, String> set:map.entrySet())
		{
			if (set.getKey().equalsIgnoreCase("mobile"))
			{
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());
			}
			else if(set.getKey().equalsIgnoreCase("email"))
			{
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());
			}
			else
			{
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			}
		}	*/
	}
	
	public Object[][] excelData(String sheetname) throws Throwable
	{
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(sheetname);
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
}


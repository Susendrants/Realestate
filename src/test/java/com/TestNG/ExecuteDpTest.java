package com.TestNG;

import org.testng.annotations.Test;

public class ExecuteDpTest {
@Test(dataProviderClass = DpTest.class, dataProvider = "store")
public void execute(String from,String to)
{
	System.out.println("From---> "+from+" To--> "+to);
}

@Test(dataProviderClass = DataProvidersExcelTest.class, dataProvider = "excelData")
public void executeExcel(String State, String Capital) 
{
	System.out.println(State+"------>"+Capital);
}

@Test(dataProviderClass = DataProvidersExcelTest.class, dataProvider = "DataExcelUtiles")
public void executeExcelUtils(String State, String Capital)
{
	System.out.println(State+"------>"+Capital);
}



}

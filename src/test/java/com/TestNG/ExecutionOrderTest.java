package com.TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ExecutionOrderTest {
@BeforeSuite
public void bs1()
{
	System.out.println("BS1");
}
@BeforeClass
public void bc1()
{
	System.out.println("BC1");
}
@BeforeClass
public void bC2()
{
	System.out.println("BC2");
}
@Test
public void test1()
{
	System.out.println("Test1");
}
@BeforeMethod
public void method1()
{
	System.out.println("BM1");
}
@AfterMethod
public void aftermethod1()
{
	System.out.println("AM1");
}
@AfterClass
public void afterClass1()
{
	System.out.println("AC1");
}
@Test
public void test2()
{
	System.out.println("Test 2");
}
@BeforeMethod
public void beforeMethod2()
{
	System.out.println("BM2");
}
@AfterClass
public void afterClass2()
{
	System.out.println("AC2");
}
@BeforeMethod
public void beforeMethod3()
{
	System.out.println("BM3");
}
@AfterMethod
public void aM2()
{
	System.out.println("AM2");
}
@AfterSuite
public void aS2()
{
	System.out.println("AS2");
}


}

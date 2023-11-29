package com.TestNG;

import org.testng.annotations.Test;

import com.realestate.GenericUtils.BaseClass;

public class DemoTest extends BaseClass {
@Test(groups = "smoke")
public void demo_1()
{
	System.out.println("Demo 1");
}
@Test(groups="regression")
public void demo_2()
{
	System.out.println("Demo 2");
}
}

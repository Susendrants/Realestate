package com.TestNG;

import org.testng.annotations.Test;

import com.realestate.GenericUtils.BaseClass;

public class SimpleTest extends BaseClass {
	@Test(groups="smoke")
	public void simple_1()
	{
		System.out.println("SIMPLE 1");
	}
	@Test(groups="regression")
	public void simple_2()
	{
		System.out.println("SIMPLE 2");
	}
}

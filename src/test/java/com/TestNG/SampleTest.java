package com.TestNG;

import org.testng.annotations.Test;

import com.realestate.GenericUtils.BaseClass;

public class SampleTest extends BaseClass {
	@Test
	public void sample_1()
	{
		System.out.println("SAMPLE 1");
	}
	@Test(groups="smoke")
	public void sample_2()
	{
		System.out.println("SAMPLE 2");
	}
}

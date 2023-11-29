package com.TestNG;

import org.testng.annotations.Test;

import com.realestate.GenericUtils.BaseClass;

public class PracticeTest extends BaseClass{
	@Test(groups={"smoke","regression"})
	public void practice_1()
	{
		System.out.println("PRACTICE 1");
	}
	@Test
	public void practice_2()
	{
		System.out.println("PRACTICE 2");
	}
}

package com.TestNG;

import org.testng.annotations.Test;

public class PracticeTestNGTest {
	
@Test
public void a()
{
	System.out.println("a");
}
@Test
public void b()
{
	System.out.println("b");
}
@Test(dependsOnMethods = "b")
public void c()
{
	System.out.println("c");
}
@Test
public void d()
{
	System.out.println("d");
}
@Test
public void e()
{
	System.out.println("e");
}
@Test
public void f()
{
	System.out.println("f");
}


}

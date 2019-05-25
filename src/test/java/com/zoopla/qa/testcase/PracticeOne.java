package com.zoopla.qa.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeOne extends BaseClass{

	SoftAssert softassert = new SoftAssert();
	

	@Test(priority = 1)
	public void login1() {
		System.out.println(" class 1  login operation");
		
		softassert.assertEquals("Sachin", "patil",  "missed");
		System.out.println(" class 1  login operation");
		System.out.println(" class 1  login operation");
		softassert.assertAll();
		
	}

	@Test(priority = 2)
	public void click1() {
		System.out.println("class 1 click operation");
		System.out.println("Hello1");
		Assert.assertEquals("UK", "Parola", "Wrong village");
		System.out.println("Hello2");
		
	}

	@Test(priority = 3)
	public void logout1() {
		System.out.println("class 1 logout operation");
	}

	
}

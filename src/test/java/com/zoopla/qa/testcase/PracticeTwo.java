package com.zoopla.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PracticeTwo extends BaseClass {

	@Test(priority = 1)
	public void login2() {
		System.out.println("class 2 login operation");
	}

	@Test(priority = 2)
	public void click2() {
		System.out.println("class 2 click operation");
	}

	@Test(priority = 3)
	public void logout2() {
		System.out.println("class 2  logout operation");
	}

}

package com.zoopla.qa.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	@BeforeSuite
	public void extension(){
		System.out.println("will add extension");
	}
	
	@AfterSuite
	public void removeextension(){
		System.out.println("will remove extension");
	}
	
	@BeforeTest
	public void homePageTitle() {
		System.out.println("BaseClass verify homePageTitle");
	}
	
	@AfterTest
	public void logoutPageTitle() {
		System.out.println("BaseClass verify homePageTitle");
	}
		
	@BeforeClass
	public void browserLaunch() {
		System.out.println("BaseClass Browser will launch");
	}
	
	@AfterClass
	public void browserClose(){
		System.out.println("BaseClass Browser will launch");
	}
}

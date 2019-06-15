package com.zoopla.qa.testcase;

import static com.zoopla.qa.testdata.Constant.prop;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyPage;
import com.zoopla.qa.pages.SalePage;

public class PropertyPageTest extends TestBase{

	public static String name;
	
	public PropertyPageTest() throws IOException {
		super();
		
	}
	SalePage salePage;
	HomePage homePage;
	PropertyPage propertyPage;
	 @Parameters({"browser", "url"})
	@BeforeClass
	public void classIntialize(String browser , String url) throws IOException{
			initialization(browser, url);
		 homePage =new HomePage();
		 salePage =	new SalePage();
		 propertyPage = new PropertyPage();
		 homePage.passLocation();
			homePage.clicOnSearch();
			salePage.clickOnProperty(Integer.parseInt(prop.getProperty("position")));
	}
	

	@Test(priority=4)
	public void agentDetails() throws IOException{
		System.out.println("In Agent Test");
		propertyPage.getTextAgentContact();
		propertyPage.getTextAgentLogo();
		name =propertyPage.getTextAgentName();
		
		System.out.println("agentPage.getTextAgentContact();" + propertyPage.getTextAgentContact());
		//System.out.println("agentPage.getTextAgentLogo();;" + propertyPage.getTextAgentLogo());
		System.out.println("agentPage.getTextAgentName();" +propertyPage.getTextAgentName());
		System.out.println("agentPage.getTextAgentName();" +propertyPage.getTextAgentAddress());		
		propertyPage.clickOnAgent();		
		
	}
	@AfterClass
	public void tearDown(){
		driver.quit();
	}

}

package com.zoopla.qa.testcase;

import java.io.IOException;
import static com.zoopla.qa.testdata.Constant.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.SalePage;
@Listeners(com.zoopla.qa.listener.Listener.class)
public class SalePageTest extends TestBase{

	
	public SalePageTest() throws IOException {
		super();
	}
	
	SalePage salePage;
	HomePage homePage;
	@BeforeClass
	public void classIntialize() throws IOException{
		initialization();
		 homePage =new HomePage();
		 salePage =	new SalePage();
		 homePage.passLocation();
			homePage.clicOnSearch();
		
	}
	@Test(priority = 2)
	public void verifyPropertyPageTitle() throws IOException, InterruptedException {	
		Thread.sleep(3000);
		
		System.out.println("price price value==>" + driver.getTitle());
		System.out.println("price price value==>" + prop.getProperty("PropertyPageTitle"));

//	Assert.assertEquals(driver.getTitle(), prop.getProperty("PropertyPageTitle"));
	
	}
	
	@Test(priority=3)
	public void printPrice() throws IOException{
		salePage.getTextFromPrice();
		salePage.clickOnProperty(Integer.parseInt(prop.getProperty("position")));
		System.out.println("In Sales Test");
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}

package com.zoopla.qa.testcase;

import java.io.IOException;
import static com.zoopla.qa.testdata.Constant.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.AgentDetailsPage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyPage;
import com.zoopla.qa.pages.SalePage;

public class HomePageTest extends TestBase {

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	 HomePage homePage;
	 
	@BeforeClass
	@Parameters("browser")
	public void classIntialize(String browser) throws IOException{
		
		initialization(browser);
		 homePage =new HomePage();
		
	}

	@Test(priority = 0)
	public void verifyHomePageTitle() throws IOException {

		Assert.assertEquals(driver.getTitle(), prop.getProperty("HomePageTitle"));
	}

	@Test(priority = 1)
	public void searchLocation() throws IOException {
		
		homePage.passLocation();
		homePage.clicOnSearch();
	}
	@AfterClass
	public void tearDown(){
		driver.close();
	}

}

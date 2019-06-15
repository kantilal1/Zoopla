package com.zoopla.qa.testcase;

import java.io.IOException;
import static com.zoopla.qa.testcase.PropertyPageTest.*;
import static com.zoopla.qa.testdata.Constant.prop;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.zoopla.qa.base.TestBase;
import com.zoopla.qa.pages.AgentDetailsPage;
import com.zoopla.qa.pages.HomePage;
import com.zoopla.qa.pages.PropertyPage;
import com.zoopla.qa.pages.SalePage;

public class AgentDetailsPageTest extends TestBase {


	public AgentDetailsPageTest() throws IOException {
		super();
	}
	SalePage salePage;
	HomePage homePage;
	PropertyPage propertyPage;
	AgentDetailsPage agentDetailsPage;
	@Parameters({"browser","url"})
	@BeforeClass
	public void classIntialize(String browser, String url) throws IOException{
		initialization(browser, url);
		 homePage =new HomePage();
		 salePage =	new SalePage();
		 propertyPage = new PropertyPage();
		 agentDetailsPage = new AgentDetailsPage();
		 homePage.passLocation();
			homePage.clicOnSearch();
			salePage.clickOnProperty(Integer.parseInt(prop.getProperty("position")));
			name =propertyPage.getTextAgentName();
			propertyPage.clickOnAgent();
	}
	
	@Test(priority=5)
	public void verifyAgentDetails() throws IOException{
		
		System.out.println("name==>" +name);
		System.out.println("agentDetailsPage.getTextAgentName()==>" +agentDetailsPage.getTextAgentName());

		Assert.assertEquals(name, agentDetailsPage.getTextAgentName(), "Name of agent is not matched");
		
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

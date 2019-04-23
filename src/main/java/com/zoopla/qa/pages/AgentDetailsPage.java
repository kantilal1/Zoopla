package com.zoopla.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class AgentDetailsPage extends TestBase{

	public AgentDetailsPage() throws IOException {
	PageFactory.initElements(driver, this);	
	
	}
	
	@FindBy(xpath="//div[@id='content']//b")
	WebElement headAgentName;
	
	
	public String getTextAgentName(){
		
		System.out.println("headAgentName.getText()==>" +headAgentName.getText());
		return headAgentName.getText();
	}
	
	
	
	

}

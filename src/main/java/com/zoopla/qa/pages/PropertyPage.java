package com.zoopla.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class PropertyPage extends TestBase{

	public PropertyPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//h4[@class='ui-agent__name']")
	WebElement agentName;
	
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//p[@class='ui-agent__tel ui-agent__text']")
	WebElement agentContact;
	
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//img[@class='js-lazy-loaded']")
	WebElement agentLogo;
	
	@FindBy(xpath = "//div[@class='dp-sidebar-wrapper__contact']//address[@class='ui-agent__address']")
	WebElement agentAddress;
	
	
	public String getTextAgentName(){
		return agentName.getText();
		
	}
	
	public String getTextAgentAddress(){
		return agentAddress.getText();
		
	}
	
	public String getTextAgentContact(){
		return agentContact.getText();
		
	}
	
	public String getTextAgentLogo(){
		return agentLogo.getText();
		
	}
	
	public void clickOnAgent(){
		agentName.click();
	}
	
	

}

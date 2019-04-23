package com.zoopla.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.zoopla.qa.testdata.Constant.*;
import com.zoopla.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='search-input-location']")
	WebElement location;
	
	@FindBy(xpath="//button[@id='search-submit']")
	WebElement search;
	
	
	public void passLocation(){
		location.click();
		location.sendKeys(loc);
		
	}
	public void clicOnSearch(){
		search.click();
		
	}
	
	
}

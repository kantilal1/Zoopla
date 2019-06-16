package com.zoopla.qa.testcase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLightingElement {
	
	
	
	
	// mukesh said he will post new video for how we can call automatically while performing action on element instead of calling it every time
	//in class.
	
	public static void highLightElement(WebElement element , WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("arguments[0]. setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		
		Thread.sleep(5000);
		
		js.executeScript("arguments[0].setAttribute('style', 'border:'jjj solid 2px white');", element);
		
		
		
		
		
	}

}

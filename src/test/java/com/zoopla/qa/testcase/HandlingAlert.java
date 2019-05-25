package com.zoopla.qa.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAlert {

	static WebDriver driver;

	public static void main(String[] args) {

		// System.setProperty("webdriver.chrome.driver", "");
		// WebDriverManager.chromedriver().setup();
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(" Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.guru99.com/test/delete_customer.php");
		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).click();
		alertPopup();
		System.out.println("NO exception bhai");
	}

	public static void alertPopup() {// This method will help to handle alert popup
		// driver.get("http://demo.guru99.com/test/delete_customer.php"); link
		// for alert	
		try{
			Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		System.out.println("Alert text" + alerttext);
		alert.accept();
		System.out.println("done");
		/*driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();*/
		
		}catch(Exception e){
			
		}

	}

}

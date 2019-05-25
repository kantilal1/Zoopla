package com.zoopla.qa.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIframe {

	static WebDriver driver;

	public static void main(String[] args) {

		// iframe is another html docuemnt from the webpage.
		// we can handle iframe b y 3 way (id,name), index value and webelement.
		
		// System.setProperty("webdriver.chrome.driver", "");
		// WebDriverManager.chromedriver().setup();
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println(" Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/guru99home/");
		System.out.println("NO exception bhai");
		int my_iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total iframes on the page" +my_iframes);
	}

	

}

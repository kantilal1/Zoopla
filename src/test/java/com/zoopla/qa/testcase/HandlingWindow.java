package com.zoopla.qa.testcase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingWindow {

	static WebDriver driver;
	public static void main(String[] args) {
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/"); // handle window	
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		System.out.println("Title of the page ==>" +driver.getTitle()) ;
		String parent_window = driver.getWindowHandle();
		System.out.println("parent_window==>" +parent_window);
		WebElement service_click = driver.findElement(By.xpath("//div[contains(text(),'Services')]"));
		service_click.click();
		
		Set<String> allWindows=driver.getWindowHandles();
		System.out.println("Total windows==>" +allWindows.size());
		ArrayList<String> window = new ArrayList<String>(allWindows);
	
	
		driver.switchTo().window(window.get(1));
		System.out.println("Title of the page  window 1==>" +driver.getTitle()) ;
	
		driver.switchTo().window(window.get(2));
		System.out.println("Title of the page ==>" +driver.getTitle()) ;
		
		driver.switchTo().window(parent_window);
		System.out.println("Title of the page ==>" +driver.getTitle()) ;

		
	}
	//OR we can do like below for code reusability
	public static void switchMethodWindow(int i){
		Set<String> allWindows=driver.getWindowHandles();
		ArrayList<String> window = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(window.get(i));
		
	}

}

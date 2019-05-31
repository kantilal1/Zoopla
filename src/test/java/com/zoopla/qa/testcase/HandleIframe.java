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

	public static void main(String[] args) throws InterruptedException {
		// iframe is another html docuemnt from the webpage.
		// we can handle iframe b y 3 way (id,name), index value and webelement.
		// System.setProperty("webdriver.chrome.driver", "");
		// WebDriverManager.chromedriver().setup();
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();	
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/iframe-practice-page/"); // iFrame url
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

		int my_iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total iframes on the page" + my_iframes);
		
		//handling iframe by id/name
		System.out.println("Switching on frame using index value");
		handleFrameIndex(1);

		WebElement sortable = driver.findElement(By.xpath("//a[contains(text(), 'Sortable')]"));
		sortable.click();
		System.out.println("Switched and click on sortable");
		
		System.out.println("Switching default page ");
		driver.switchTo().defaultContent();
		WebElement homeFromMainPage = driver.findElements(By.xpath("//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'HOME')]")).get(0);
		homeFromMainPage.click();
		System.out.println("Switched and clicked default home");
		driver.navigate().back();
		Thread.sleep(6000);
		
		System.out.println("Switching on frame using String valeu name/id");
		handleFrameElement("IF2");
		WebElement Selectable = driver.findElement(By.xpath("//a[contains(text(), 'Selectable')]"));
		Selectable.click();
		
		System.out.println("Switching default page ");
		driver.switchTo().defaultContent();
		WebElement homeFromMainPage1 = driver.findElements(By.xpath("//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'HOME')]")).get(0);
		homeFromMainPage1.click();
		System.out.println("Switched and clicked default home");
		driver.navigate().back();
		Thread.sleep(6000);
		
		WebElement ele = driver.findElement(By.id("IF2"));
		handleFrameByIdAndName(ele);
		
		WebElement Resizable = driver.findElement(By.xpath("//a[contains(text(), 'Resizable')]"));
		Resizable.click();
		
	}
	
	public static void handleFrameIndex(int i){
		System.out.println("handle iframe by index==>" +i);
		try{
			driver.switchTo().frame(i);
			System.out.println("Switched and clicked");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	public static void handleFrameElement(String element){
		System.out.println("handle iframe by name/id==>" +element);
		try{
			driver.switchTo().frame(element);
			System.out.println("Switched and clicked");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void handleFrameByIdAndName(WebElement element){
		System.out.println("handle iframe by webelement");
		try{
			driver.switchTo().frame(element);
			System.out.println("Switched and clicked");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

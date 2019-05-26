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
		System.out.println(" Browser launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://toolsqa.com/iframe-practice-page/"); // iFrame url
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("NO exception bhai");
		//handling iframe by id/name
		System.out.println("Switing frame number 2");
		driver.switchTo().frame("IF2");
		WebElement sortable = driver.findElement(By.xpath("//a[contains(text(), 'Sortable')]"));
		sortable.click();
		System.out.println("Switched and click on sortable");
		
		System.out.println("Switching frame 1 ");
		driver.switchTo().frame("IF1");
		WebElement blogs = driver
				.findElements(By
						.xpath("//div[@id='page']//li[@class='menu-item menu-item-type-taxonomy menu-item-object-category menu-item-27131 dt-mega-menu mega-auto-width mega-column-3']"))
				.get(1);
		blogs.click();
		System.out.println("switched and clicked on blogs");
		driver.switchTo().defaultContent();
		System.out.println("Switching to default contanet");
		WebElement homeFromMainPage = driver.findElements(By.xpath("//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'HOME')]")).get(0);
		homeFromMainPage.click();
		System.out.println("Switched and clicked");


		
		
		// handling frame by index.
		/*int my_iframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total iframes on the page" + my_iframes);
		Thread.sleep(8000);
		System.out.println("Switing frame number 2");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.switchTo().frame(1);
		WebElement sortable = driver.findElement(By.xpath("//a[contains(text(), 'Sortable')]"));
		sortable.click();
		System.out.println("Switched and click onnsortable");
		System.out.println("Switching frame 1 ");
		driver.switchTo().frame(0);
		WebElement blogs = driver
				.findElements(By
						.xpath("//div[@id='page']//li[@class='menu-item menu-item-type-taxonomy menu-item-object-category menu-item-27131 dt-mega-menu mega-auto-width mega-column-3']"))
				.get(1);
		blogs.click();
		System.out.println("switched and clicked on blogs");
		driver.switchTo().defaultContent();
		System.out.println("Switching to default contanet");
		WebElement homeFromMainPage = driver.findElements(By.xpath("//nav[@class='navigation']//span[@class='menu-text'][contains(text(),'HOME')]")).get(0);
		homeFromMainPage.click();
		System.out.println("Switched and clicked");
*/

	}
	
	public static void handleFrameIndex(int i){
		System.out.println("handle iframe by index");
		try{
			driver.switchTo().frame(i);
		}catch(Exception e){
			System.out.println("Switched and clicked");
		}
		
	}
	

	public static void handleFrameElement(String element){
		System.out.println("handle iframe by name/id");
		try{
			driver.switchTo().frame(element);
		}catch(Exception e){
			System.out.println("Switched and clicked");
		}
		
	}
	
	public static void handleFrameByIdAndName(WebElement element){
		System.out.println("handle iframe by webelement");
		try{
			driver.switchTo().frame(element);
		}catch(Exception e){
			System.out.println("Switched and clicked");
		}
		
	}

}

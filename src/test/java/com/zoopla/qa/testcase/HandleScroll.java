package com.zoopla.qa.testcase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleScroll {
	//In selenium we can scroll using 3 ways as mentioned below.
			// we can scroll using action class and its method called moveToElement 
			// We can scroll using sendKey(Keys.DOWN)
			// We can scroll using java script
	
	static WebDriver driver;

//	static JavascriptExecutor js =  (JavascriptExecutor)driver;
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html"); // handle window
		
		
	//	driver.findElement(By.xpath("//a[contains(@href, 'http://opensource.org/licenses/MIT')]")).sendKeys(Keys.DOWN);

		/*Actions action = new Actions(driver);	
		action.moveToElement(driver.findElement(By.xpath("//a[contains(@href, 'http://opensource.org/licenses/MIT')]"))).click().build().perform();
		*/
		
		//http://192.168.1.21:8080/ApplicantSignup/tourist
		//http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		Thread.sleep(5000);
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("scroll(0, 400)");
		//js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[text()='Cancel']")));
		//js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//div[@id='mCSB_4_container']//p[contains(text(),'Temporibus autem quibusdam et aut officiis debitis')]")));
		//scrollByPixel(400);
		//scrollByText(driver.findElement(By.xpath("//div[@id='mCSB_4_container']//p[contains(text(),'Temporibus autem quibusdam et aut officiis debitis')]")));
		
		System.out.println("scrolldone");
	}
	
 /*   public static void scrollByPixel(int i){
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("scroll(0, i)");
	}*/

	/*public static void scrollByText(WebElement element){
		JavascriptExecutor js =  (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}*/
}

package com.zoopla.qa.testcase;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class HadleDropDownUsingSelect {
	static WebDriver driver;
     static String dateOFBirth= "17/Jun/19193";

	public static void main(String[] args) {
		// we can select value from drop down using select but we have ensure that the element having select tagname in HTML code then and 
		// only we can use select class.
		// we can select value from drop down using three different way.
		// selectbyindex, selectbyvalue and selectbyvisible text so recommended is selectbyvisibletext because index might be change.
		// In selenium we can perform verification like whatever value we select value from dropdown that comes in the picture or no.
		// All listed value in drop down as displaying as requirement verify with assert.
		 
		System.out.println("Launchin browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Browser launched");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/"); // handle window
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
		WebElement day = driver.findElement(By.id("day"));
		WebElement month = driver.findElement(By.id("month"));	
		WebElement year = driver.findElement(By.id("year"));
		
		Select selectDay = new Select(day);		
		Select selectMonth= new Select(month);	
		Select selectYear = new Select(year);
		
		/*String dob = "17/Jun/1993";
		String brithdate[] = dob.split("/");
		selectDay.selectByVisibleText(brithdate[0]);
		selectMonth.selectByVisibleText(brithdate[1]);
		selectYear.selectByVisibleText(brithdate[2]);*/
		
		selectDay.selectByValue("17");		
		selectMonth.selectByIndex(6);
		selectYear.selectByVisibleText("1993");
		
		WebElement first_day  = selectDay.getFirstSelectedOption();
		WebElement first_month  = selectMonth.getFirstSelectedOption();
		WebElement first_year  = selectYear.getFirstSelectedOption();
		System.out.println(first_day.getText()+" "+first_month.getText()+" "+first_year.getText());
		Assert.assertEquals("17", first_day.getText());
		Assert.assertEquals("Jun", first_month.getText());
		Assert.assertEquals("1993", first_year.getText());
		System.out.println("Done verification");
		System.out.println("Now using getOptions method to print the size of drop down value and the print value of it");
		
		List<WebElement> totalMonths = selectMonth.getOptions();

		System.out.println("Total month in Drop down==>" +totalMonths.size());
	
		
		for (WebElement ele:totalMonths){
	
			System.out.println("Total month in Drop down text==>" +ele.getText());
		}
		
		
		
		
	}
	
	public  static void selectDropDownValueByValue(WebElement element , int i){
		Select selectDay = new Select(element);
		selectDay.selectByIndex(6);
	}
	

	public  static void selectDropDownValueByIndex(WebElement element , String value){
		Select selectDay = new Select(element);
		selectDay.selectByValue("17");
	}
	

	public  static void selectDropDownValueByVisibletext(WebElement element , String value){
		Select selectYear = new Select(element);
		selectYear.selectByVisibleText("1993");
		
	}
	

}

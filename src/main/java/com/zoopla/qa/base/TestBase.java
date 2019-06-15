package com.zoopla.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.zoopla.qa.testdata.Constant.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public TestBase() throws IOException {

		OSName = System.getProperty("os.name");
		System.out.println(OSName);
		OSName = OSName.substring(0, 3);
		System.out.println(OSName);

		if (OSName.equalsIgnoreCase("Mac")) {
			prop = new Properties();
			System.out.println("If else");
			FileInputStream fis = new FileInputStream("./src/main/java/com/zoopla/qa/config/config.properties");
			prop.load(fis);
			System.out.println("prop loaded");

		} else if (OSName.equalsIgnoreCase("Win")) {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\zoopla\\qa\\config\\config.properties");
			prop.load(fis);
		}

	}

	
	public static void initialization(String browser , String url) {

		String browserName = prop.getProperty("browser");
		System.out.println("prop loaded" +browserName);
		if (browser.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "./");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);

	}
}
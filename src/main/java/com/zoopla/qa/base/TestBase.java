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

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public TestBase() throws IOException {

		OSName = System.getProperty("os.name");
		System.out.println(OSName);
		OSName = OSName.substring(0, 4);
		System.out.println(OSName);

		if (OSName.equalsIgnoreCase("Mac")) {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/com/zoopla/qa/config/config.properties");
			prop.load(fis);

		} else if (OSName.equalsIgnoreCase("Win")) {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(".\\src\\main\\java\\com\\zoopla\\qa\\config\\config.properties");
			prop.load(fis);
		}

	}

	public static void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver", "./");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("FF")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
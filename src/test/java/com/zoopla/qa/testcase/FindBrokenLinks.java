package com.zoopla.qa.testcase;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBrokenLinks {

	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> totalLinks = driver.findElements(By.tagName("a"));

		System.out.println("Total link on google page==>" + totalLinks.size());

		/*for (WebElement link : totalLinks) {
			String links = link.getAttribute("href");
			System.out.println(" links Address==>" + links);

			urlConnectionEstablish(links);
		}*/
		
		for (int i=0; i<totalLinks.size(); i++){
			
			WebElement links  = totalLinks.get(i);
			String linkstext = links.getAttribute("href");
			
			System.out.println(" links Address==>" + linkstext);
			urlConnectionEstablish(linkstext);
		}

	}

	public static void urlConnectionEstablish(String urlname) throws IOException {
	
		URL url = new URL(urlname);
		HttpURLConnection connect = (HttpURLConnection)url.openConnection();
		connect.setConnectTimeout(3000);
		connect.connect();
		
		if(connect.getResponseCode()==200){
			System.out.println(urlname +" - "+ connect.getResponseMessage());
		}
		if(connect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println(urlname +" - "+ connect.getResponseMessage() +"-"+ HttpURLConnection.HTTP_NOT_FOUND);
			
		}
		

	}

}

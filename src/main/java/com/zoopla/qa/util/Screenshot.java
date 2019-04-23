package com.zoopla.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.zoopla.qa.testdata.Constant.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.zoopla.qa.base.TestBase;

public class Screenshot extends TestBase  {

	public Screenshot() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public static void takeScreenshot() throws IOException{
	SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	Date date = new Date();
	
	screenshot = sdf.format(date);
    TakesScreenshot take =  (TakesScreenshot) driver;
    File src = take.getScreenshotAs(OutputType.FILE);
    
    if(OSName.equalsIgnoreCase("Mac")){
    	FileUtils.copyFile(src, new File("./Screenshot/" + screenshot +".jpeg"));
    	
    }else if (OSName.equalsIgnoreCase("Windows")){
    	FileUtils.copyFile(src, new File(".\\Screenshot\\" + screenshot +".jpeg"));
    }
    
	System.out.println("screenshot==>" +screenshot);
	}
	
}

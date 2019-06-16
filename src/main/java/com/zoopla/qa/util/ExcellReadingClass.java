package com.zoopla.qa.util;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcellReadingClass {

	public static void main(String[] args) throws FileNotFoundException {
		
		File src = new File("E:\\SeleniumWorkSpace\\GhanaNewVisaApp\\src\\main\\java\\com\\ghana\\app\\qa\\testdata\\TestData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
	

	}

}

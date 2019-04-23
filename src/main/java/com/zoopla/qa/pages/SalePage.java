package com.zoopla.qa.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.zoopla.qa.base.TestBase;

public class SalePage extends TestBase {

	public SalePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='listing-results-price text-price']")
	List<WebElement> price;
	
	List<Integer> pricelist = new ArrayList<Integer>(); 
	
	
	
	public void clickOnProperty(int position){
		
		price.get(position).click();		
		
			}

	public void getTextFromPrice() {

		for (WebElement priceProperty : price) {

			if (priceProperty.getText().replaceAll("[^0-9]", "").isEmpty()) {

				System.out.println("prices value==>" + priceProperty.getText() + "Property has not value kin integer");
			} else {

				pricelist.add(Integer.parseInt(priceProperty.getText().replaceAll("[^0-9]", "")));
			}
			
			Collections.sort(pricelist, Collections.reverseOrder());
			
			System.out.println("Decending order by using collection==>" +pricelist);

		}
	}

}

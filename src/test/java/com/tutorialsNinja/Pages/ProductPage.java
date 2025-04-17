package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	public WebDriver driver;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement productDescription;
	
	@FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
	private WebElement invalidProductMessage;
	
	@FindBy(xpath = "//p[contains(text(), 'There is no product that matches the search criteria.')]")
	private WebElement NoProductMessage;
	
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean statusDisplayOfProduct() {
		boolean status = productDescription.isDisplayed();
		return status;
	}
	
	public boolean statusDisplayOfInvalidProduct() {
		boolean status = invalidProductMessage.isDisplayed();
		return status;
	}
	
	public boolean statusDisplayOfNoProduct() {
		boolean status = NoProductMessage.isDisplayed();
		return status;
	}


}

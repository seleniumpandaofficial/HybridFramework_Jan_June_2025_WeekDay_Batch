package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public WebDriver driver;

    //identify the WebElements or Objects
    //Initialize those Objects
    //Define those Objects - Actions

    @FindBy(linkText = "My Account")
    private WebElement MyAccountDropDown;

    @FindBy(linkText = "Login")
    private WebElement LoginOption;

    @FindBy(linkText = "Register")
    private WebElement RegisterOption;
    
    @FindBy(name = "search")
    private WebElement searchBar;
    
    @FindBy(css = "button.btn.btn-default.btn-lg")
    private WebElement searchButton;

    public LandingPage(WebDriver driver){
           this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAccountDropdown(){
        MyAccountDropDown.click();
    }

    public LoginPage clickOnLoginOption(){
        LoginOption.click();
        return new LoginPage(driver);
    }
    
    public LoginPage combiningTwoActionsToNavigateToLoginPage() {
    	MyAccountDropDown.click();
    	LoginOption.click();
        return new LoginPage(driver);
    }

    public void clickOnRegisterOption(){
        RegisterOption.click();
    }
    
    public RegisterPage combiningTwoActionsToNavigateToRegisterPage() {
    	MyAccountDropDown.click();
    	RegisterOption.click();
        return new RegisterPage(driver);
    }
    
    public void enterProduct(String producttext) {
    	searchBar.sendKeys(producttext);
    }
    
    public ProductPage clickOnSearchButton() {
    	searchButton.click();
    	return new ProductPage(driver);
    }
    
    public ProductPage combiningSearchBarAndSearchButtonToNavigateToProductPage(String producttext) {
    	searchBar.sendKeys(producttext);
    	searchButton.click();
    	return new ProductPage(driver);
    }
}

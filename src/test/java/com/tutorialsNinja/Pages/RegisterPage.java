package com.tutorialsNinja.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;

    @FindBy(id = "input-firstname")
    private WebElement firstnameTextBox;

    @FindBy(id = "input-lastname")
    private WebElement lastnameTextBox;

    @FindBy(id = "input-email")
    private WebElement emailTextBox;

    @FindBy(id = "input-telephone")
    private WebElement telephoneTextBox;

    @FindBy(id = "input-password")
    private WebElement passwordTextBox;

    @FindBy(id = "input-confirm")
    private WebElement confirmpasswordTextBox;

    @FindBy(xpath = "//input[@name = 'newsletter' and @value = '1']")
    private WebElement subscribeNewsLetterRadioButton;

    @FindBy(xpath = "//input[@name = 'agree' and @value = '1']")
    private WebElement privacypolicyCheckBox;

    @FindBy(css = "input.btn.btn-primary")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(), 'Warning: E-Mail Address is already registered!')]")
    private WebElement duplicateEmailWarning;

    @FindBy(xpath = "//div[contains(text(), 'Password confirmation does not match password!')]")
    private WebElement passwordMismatch;

    @FindBy(xpath = "//div[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")
    private WebElement privacyPolicyWarning;

    @FindBy(xpath = "//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")
    private WebElement firstnameWarning;

    @FindBy(xpath = "//div[contains(text(), 'Last Name must be between 1 and 32 characters!')]")
    private WebElement lastnameWarning;

    @FindBy(xpath = "//div[contains(text(), 'E-Mail Address does not appear to be valid!')]" )
    private WebElement emailWarning;

    @FindBy(xpath = "//div[contains(text(), 'Telephone must be between 3 and 32 characters!')]")
    private WebElement telephoneWarning;

    @FindBy(xpath = "//div[contains(text(), 'Password must be between 4 and 20 characters!')]")
    private WebElement passwordWarning;


    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstnametext){
        firstnameTextBox.sendKeys(firstnametext);
    }

    public void enterLastName(String lastnametext){
        lastnameTextBox.sendKeys(lastnametext);
    }

    public void enterEmail(String emailtext){
        emailTextBox.sendKeys(emailtext);
    }

    public void enterTelephone(String telephonetext){
        telephoneTextBox.sendKeys(telephonetext);
    }

    public void enterPassword(String passwordtext){
        passwordTextBox.sendKeys(passwordtext);
    }

    public void enterConfirmPassword(String confirmpasswordtext){
        confirmpasswordTextBox.sendKeys(confirmpasswordtext);
    }


    public void selectYesSubscribeNewsLetter(){
        subscribeNewsLetterRadioButton.click();
    }

    public void checkPrivacyPolicy(){
        privacypolicyCheckBox.click();
    }

    public AccountSuccessPage clickOnContinueButton(){
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public boolean displayStatusOfDuplicateEmailWarning(){
        boolean status = duplicateEmailWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfPasswordMismatch(){
        boolean status = passwordMismatch.isDisplayed();
        return status;
    }

    public boolean displayStatusOfPrivacyCheckboxNotChecked(){
        boolean status = privacyPolicyWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfFirstnameEmptyWarning(){
        boolean status = firstnameWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfLastnameEmptyWarning(){
        boolean status = lastnameWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfEmailEmptyWarning(){
        boolean status = emailWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfTelephoneEmptyWarning(){
        boolean status = telephoneWarning.isDisplayed();
        return status;
    }

    public boolean displayStatusOfPasswordEmptyWarning(){
        boolean status = passwordWarning.isDisplayed();
        return status;
    }
    
    public AccountSuccessPage combiningManatoryDetailsToNavigateToAccountSuccessPage(String firstnametext, String lastnametext, String emailtext, String telephonetext, String passwordtext,
    		                                                                         String confirmpasswordtext) {
    	 firstnameTextBox.sendKeys(firstnametext);
    	 lastnameTextBox.sendKeys(lastnametext);
    	 emailTextBox.sendKeys(emailtext);
    	 telephoneTextBox.sendKeys(telephonetext);
    	 passwordTextBox.sendKeys(passwordtext);
    	 confirmpasswordTextBox.sendKeys(confirmpasswordtext);
    	 privacypolicyCheckBox.click();
    	 continueButton.click(); 
         return new AccountSuccessPage(driver);
    	
    }
    
   public AccountSuccessPage combiningAllDetailsToNavigateToAccountSuccessPage(String firstnametext, String lastnametext, String emailtext, String telephonetext, String passwordtext,
                                                                                String confirmpasswordtext) {
            firstnameTextBox.sendKeys(firstnametext);
            lastnameTextBox.sendKeys(lastnametext);
            emailTextBox.sendKeys(emailtext);
            telephoneTextBox.sendKeys(telephonetext);
            passwordTextBox.sendKeys(passwordtext);
            confirmpasswordTextBox.sendKeys(confirmpasswordtext);
            subscribeNewsLetterRadioButton.click();
            privacypolicyCheckBox.click();
            continueButton.click(); 
            return new AccountSuccessPage(driver);

}
   
   public boolean displayStatusOfAllWarningMessages(){
	   continueButton.click();
	   boolean privacypolicystatus = privacyPolicyWarning.isDisplayed(); 
	   boolean firtnamestatus = firstnameWarning.isDisplayed();
	   boolean lastnamestatus = lastnameWarning.isDisplayed();;
	   boolean emailstatus = emailWarning.isDisplayed();;
	   boolean telephonestatus = telephoneWarning.isDisplayed();;
	   boolean passwordstatus = passwordWarning.isDisplayed();
	   
	   return privacypolicystatus && firtnamestatus && lastnamestatus && emailstatus && telephonestatus && passwordstatus;
       
   }

}

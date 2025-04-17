package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.tutorialsNinja.Pages.AccountSuccessPage;
import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.RegisterPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.DataProvider_ExcelCode;
import com.tutorialsNinja.Utilities.Utils;

public class RegisterTest extends TestBase {

    public WebDriver driver;
    public SoftAssert softassert = new SoftAssert();
    public  LandingPage landingpage;
    public RegisterPage registerpage;
    public AccountSuccessPage accountsuccesspage;

    public RegisterTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
        landingpage = new LandingPage(driver);
        registerpage = landingpage.combiningTwoActionsToNavigateToRegisterPage(); 
    }

    @Test(priority=1, enabled = false, dataProvider = "registerData", dataProviderClass = DataProvider_ExcelCode.class)
    public void verifyRegisterWithMandatoryDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) throws InterruptedException {
  
    	accountsuccesspage = registerpage.combiningManatoryDetailsToNavigateToAccountSuccessPage(firstname, lastname, lastname, telephone, password, confirmPassword);
        softassert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccessMessage());
        softassert.assertAll();
    }

    @Test(priority=2,enabled = false, dataProvider = "registerData", dataProviderClass = DataProvider_ExcelCode.class)
    public void verifyRegisterWithAllDetails(String firstname, String lastname, String telephone, String password, String confirmPassword) throws InterruptedException {
    	accountsuccesspage = registerpage.combiningAllDetailsToNavigateToAccountSuccessPage(firstname, lastname, lastname, telephone, password, confirmPassword);
        softassert.assertTrue(accountsuccesspage.displayStatusOfAccountSuccessMessage());
        softassert.assertAll();
    }

    @Test(priority=3)
    public void verifyRegisterWithExistingEmail(){
    	registerpage.combiningAllDetailsToNavigateToAccountSuccessPage(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),prop.getProperty("validEmail"),
    			                                                       dataprop.getProperty("telephone"), dataprop.getProperty("password"), 
    			                                                       dataprop.getProperty("confirmPassword"));
        softassert.assertTrue(registerpage.displayStatusOfDuplicateEmailWarning());
        softassert.assertAll();
    }

    @Test(priority=4)
    public void verifyRegisterWithIncorrectConfirmPassword(){
    	registerpage.combiningAllDetailsToNavigateToAccountSuccessPage(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Utils.emailWithDateTimeStamp(),
                                                                       dataprop.getProperty("telephone"), dataprop.getProperty("password"), 
                                                                       dataprop.getProperty("invalidPassword"));
        softassert.assertTrue(registerpage.displayStatusOfPasswordMismatch());
        softassert.assertAll();
    }

    @Test(priority=5)
    public void verifyRegisterWithNoDetails(){
    	registerpage.displayStatusOfAllWarningMessages();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

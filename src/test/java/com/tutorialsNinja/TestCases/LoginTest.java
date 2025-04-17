package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.tutorialsNinja.Pages.AccountPage;
import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.LoginPage;
import com.tutorialsNinja.TestBase.TestBase;
import com.tutorialsNinja.TestData.DataProvider_ExcelCode;

public class LoginTest extends TestBase {

    public WebDriver driver;
    public SoftAssert softassert = new SoftAssert();
    public LandingPage landingpage;
    public LoginPage loginpage;
    public AccountPage accountpage;

    public LoginTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser")); //this opens LandingPage
        landingpage = new LandingPage(driver);
        loginpage =  landingpage.combiningTwoActionsToNavigateToLoginPage();      
    }


    @Test(priority=1, enabled = false, dataProvider = "loginData", dataProviderClass = DataProvider_ExcelCode.class)
    public void verifyLoginWithValidCredentials(String email, String password) {
        accountpage = loginpage.navigateToLoginPageCombiningThreeActions(email, password);
        softassert.assertTrue(accountpage.validateDisplayStatusOfLogoutLink());
        softassert.assertAll();
    }

    @Test(priority=2)
    public void verifyLoginWithValidEmailInvalidPassword(){
    	loginpage.navigateToLoginPageCombiningThreeActions(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
        softassert.assertTrue(loginpage.retrieveLoginWarningText().contains(dataprop.getProperty("invalidLoginWarningMessage")));
        softassert.assertAll();
    }


    @Test(priority=3)
    public void verifyLoginWithInvalidEmailValidPassword() {
    	loginpage.navigateToLoginPageCombiningThreeActions(dataprop.getProperty("invalidEmail"), prop.getProperty("validPassword"));
        softassert.assertTrue(loginpage.retrieveLoginWarningText().contains(dataprop.getProperty("invalidLoginWarningMessage")));
        softassert.assertAll();

    }

    @Test(priority=4)
    public void verifyLoginWithInvalidCredentials(){
    	loginpage.navigateToLoginPageCombiningThreeActions(dataprop.getProperty("invalidEmail"), dataprop.getProperty("invalidPassword"));
        softassert.assertTrue(loginpage.retrieveLoginWarningText().contains(dataprop.getProperty("invalidLoginWarningMessage")));
        softassert.assertAll();
    }

    @Test(priority=5)
    public void verifyLoginWithNoCredentials(){
        loginpage.clickOnLoginButton();
        softassert.assertTrue(loginpage.retrieveLoginWarningText().contains(dataprop.getProperty("invalidLoginWarningMessage")));
        softassert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

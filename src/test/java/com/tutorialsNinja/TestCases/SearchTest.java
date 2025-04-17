package com.tutorialsNinja.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialsNinja.Pages.LandingPage;
import com.tutorialsNinja.Pages.ProductPage;
import com.tutorialsNinja.TestBase.TestBase;

public class SearchTest extends TestBase {

    public WebDriver driver;
    public SoftAssert softassert = new SoftAssert();
    public LandingPage landingpage;
    public ProductPage productpage;

    public SearchTest() throws Exception {
        super();
    }

    @BeforeMethod
    public void setup(){
        driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
    }

    @Test(priority=1)
    public void searchWithValidProduct(){
     landingpage = new LandingPage(driver);
     productpage = landingpage.combiningSearchBarAndSearchButtonToNavigateToProductPage(dataprop.getProperty("validProduct"));
     softassert.assertTrue(productpage.statusDisplayOfProduct());
     softassert.assertAll();
    }

    @Test(priority=2)
    public void searchWithInvalidProduct(){
    	landingpage = new LandingPage(driver);
        productpage = landingpage.combiningSearchBarAndSearchButtonToNavigateToProductPage(dataprop.getProperty("invalidProduct"));
        softassert.assertFalse(productpage.statusDisplayOfInvalidProduct()); //deliberately failing to showcase in Listeners
        softassert.assertAll();
    }

    @Test(priority=3, dependsOnMethods = "searchWithInvalidProduct") //this will get skipped
    public void searchWithNoProduct(){
    	landingpage = new LandingPage(driver);
    	productpage = landingpage.clickOnSearchButton();
        softassert.assertTrue(productpage.statusDisplayOfNoProduct());
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

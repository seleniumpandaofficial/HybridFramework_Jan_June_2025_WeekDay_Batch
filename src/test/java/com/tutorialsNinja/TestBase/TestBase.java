package com.tutorialsNinja.TestBase;

import com.tutorialsNinja.Utilities.Utils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class TestBase {

    public  Properties prop;
    public FileInputStream ip;
    public FileInputStream ip1;
    public WebDriver driver;
    public ChromeOptions options;
    public Properties dataprop;


    public TestBase() throws Exception {
        prop = new Properties();
        ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsNinja\\Config\\config.properties");
        prop.load(ip);

        dataprop = new Properties();
        ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\tutorialsNinja\\TestData\\testData.properties");
        dataprop.load(ip1);

    }

    public WebDriver initializeBrowserAndOpenApplication(String browserName){
        if(browserName.equals(prop.getProperty("browser"))){
            options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-infobars"));
            driver = new ChromeDriver(options);
        }else if(browserName.equals("Firefox")){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }else if(browserName.equals("Edge")){
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }else {
            System.out.println("Browser Does Not Exist");
        }

        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGELOADTIMEOUT_WAIT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utils.SCRIPTTIMEOUT_WAIT));
        driver.get(prop.getProperty("url"));
        return driver;
    }



}

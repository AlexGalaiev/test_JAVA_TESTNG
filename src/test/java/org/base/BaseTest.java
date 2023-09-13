package org.base;

import org.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.webdriver.WebDriverType;

public class BaseTest {
    public static WebDriver driver;

    @BeforeSuite()
    public void beforeSuite(){
        driver = org.webdriver.WebDriverFactory.getDriver(WebDriverType.FIREFOX_DRIVER);
    }
    @AfterSuite()
    public void afterSuite() {
        driver.quit();
    };

    public void goToUrl(String URL){
        driver.get(URL);
    }

}

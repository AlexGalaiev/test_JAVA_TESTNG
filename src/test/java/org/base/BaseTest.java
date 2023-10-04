package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.constants.ApplicationConstants;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

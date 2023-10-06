package org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestApi {
    public BrowserMobProxy bmp;
    public WebDriver driver;

    @BeforeSuite
    public void installProxyServer(){
        bmp = new BrowserMobProxyServer();
        bmp.setTrustAllServers(true);
        bmp.setHarCaptureTypes(CaptureType.getAllContentCaptureTypes());
        bmp.setHarCaptureTypes(CaptureType.getResponseCaptureTypes());
        bmp.start(0);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(bmp);
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setCapability("proxy", seleniumProxy);
        firefoxOptions.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void closedriver(){
        bmp.stop();
        driver.quit();
    }
    public void goToUrl(String URL){
        driver.get(URL);
    }
}

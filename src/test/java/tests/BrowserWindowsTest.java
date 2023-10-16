package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.BrowserWindowsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_BROWSER_WINDOWS);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void browserWindowsNewTabTest(){
        new BrowserWindowsPage(driver)
                .switchToNewTab();
        Assert.assertEquals(new BrowserWindowsPage(driver).getCurentUrl(),
                "https://demoqa.com/sample");
    }
    @Test
    public void browserWindowsNewWindow(){
        new BrowserWindowsPage(driver)
                .openNewWindow();
        Assert.assertEquals(new BrowserWindowsPage(driver).getExternalWindowText(), "This is a sample page");

    }
    @Test
    public void browserWindowsNewExternalWindowWithTextTest(){
        new BrowserWindowsPage(driver)
                .openNewWindowWithMSG();
        Assert.assertEquals(new BrowserWindowsPage(driver).getExternalBodyText().toString(),
                "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
    }
}

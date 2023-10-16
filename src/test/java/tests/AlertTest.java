package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.AlertPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_ALERT_PAGE);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
    @Test
    public void alertPageTest(){
        new AlertPage(driver)
                .clickAlertBtn();
        Assert.assertEquals(new AlertPage(driver).getMsgFromAlert().toString(),
                "You clicked a button");
    }
    @Test
    public void alertPageWithDelayTest(){
        new AlertPage(driver)
                .clickAlertBtnWithDelay();
        Assert.assertEquals(new AlertPage(driver).getMsgFromAlert().toString(),
                "This alert appeared after 5 seconds");
    }
    @Test
    public void alertPageWith2Btns(){
        new AlertPage(driver)
                .clickAlertWith2Btns()
                .acceptAlert();
        Assert.assertEquals(new AlertPage(driver).confirmationResultMSG.getText().toString(),
                "You selected Ok");
        new AlertPage(driver)
                .clickAlertWith2Btns()
                .dismissAlert();
        Assert.assertEquals(new AlertPage(driver).confirmationResultMSG.getText().toString(),
                "You selected Cancel");
    }
    @Test
    public void alertPageWithMSGField(){
        String randomMSG = new AlertPage(driver).generateRandomMSG();
        new AlertPage(driver)
                .clickAlertBtnWithTextMsg()
                .sendTextToAllert(randomMSG);
        Assert.assertEquals("You entered " + randomMSG,
                new AlertPage(driver).confirmationMSG.getText().toString());
    }
}

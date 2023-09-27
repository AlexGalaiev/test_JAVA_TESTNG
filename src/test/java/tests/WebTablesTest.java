package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.WebTablePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_WEBTABLES);
    }
    @AfterMethod
    public void afterMethod() {driver.quit();}

    @Test
    public void addBtnTest(){
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.closeExistFields()
                .createUserInBase(1);
        Assert.assertTrue(webTablePage.deleteFiledBtns.size()>0);
    }

    @Test
    public void editWebTableBtnTest(){
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.closeExistFields()
                .createUserInBase(1)
                .editEmailFieldInWebTable();
        Assert.assertEquals(ApplicationConstants.TEST_EMAIL, webTablePage.getUserCredentialsFromWebList(3));

    }
    @Test
    public void searchBtnTest() {
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.closeExistFields()
                .createUserInBase(4)
                .useSearchField(webTablePage.getUserCredentialsFromWebList(4));
        Assert.assertTrue(webTablePage.сheckElementInWebTable(webTablePage.getUserCredentialsFromWebList(4)));
    }
}

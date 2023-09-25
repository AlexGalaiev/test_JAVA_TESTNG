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
    public void addingTableTest(){
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.closeExistFields()
                .addPointTofield()
                .fillRegForm();
        Assert.assertTrue(webTablePage.deleteFiledBtns.size()>0);
    }

    @Test
    public void editWebTableBtnTest(){
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.closeExistFields()
                .addPointTofield()
                .fillRegForm()
                .editEmailFieldInWebTable();
        Assert.assertEquals(ApplicationConstants.TEST_EMAIL, webTablePage.searchEmailInWebTable());

    }
 }

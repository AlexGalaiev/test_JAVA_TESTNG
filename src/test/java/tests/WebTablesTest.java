package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.WebTablePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTablesTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_WEBTABLES);
        new WebTablePage(driver).closeExistFields();
    }
    @AfterMethod
    public void afterMethod() {driver.quit();}

    @Test
    public void WebTablesTest(){
        WebTablePage webTablePage = new WebTablePage(driver);
        webTablePage.addPointTofield()
                .fillRegForm();

    }

 }

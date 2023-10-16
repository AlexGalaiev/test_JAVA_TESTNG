package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.CreationFormPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfirmationFormTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod(){
        goToUrl(ApplicationConstants.APP_URL_CONFIRMATION_FORM);
    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void confirmationFormTest(){
        CreationFormPage mainForm = new CreationFormPage(driver);
        mainForm.fillRegistartionForm();
    }
}

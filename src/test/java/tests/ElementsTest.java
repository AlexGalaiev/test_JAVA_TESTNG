package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.pageobjects.BasePage;
import org.pageobjects.ElementsPage;
import org.pageobjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.*;
import org.webdriver.WebDriverFactory;
import org.webdriver.WebDriverType;

public class ElementsTest extends BaseTest {

    @BeforeMethod
    public void beforeClass(){
        goToUrl(ApplicationConstants.APP_URL_ELEMENTS_TEXT_BOX);
    }
    @AfterMethod
    public void afterClass(){
        driver.quit();
    }
    @Test
    public void TestElements() {
        ElementsPage elementsPage = new ElementsPage(driver);
        elementsPage.fillTextBoxForm();
        Assert.assertEquals(elementsPage.textBox_finalName.getText(), "Name:" + ApplicationConstants.TEST_DATA);
        Assert.assertEquals(elementsPage.textBox_finalEmail.getText(), "Email:" + ApplicationConstants.TEST_EMAIL);
        Assert.assertEquals(elementsPage.textBox_finalcurrentAddress.getText(), "Current Address :" + ApplicationConstants.TEST_CURRENT_ADRESS);
        Assert.assertEquals(elementsPage.textBox_finalpermanentAddress.getText(), "Permananet Address :" + ApplicationConstants.TEST_PERMANENT_ADRESS);

    }

}

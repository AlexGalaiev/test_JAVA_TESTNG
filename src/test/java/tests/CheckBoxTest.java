package tests;

import org.base.BaseTest;
import org.constants.ApplicationConstants;
import org.pageobjects.CheckBoxsPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {
   @BeforeMethod
   public void beforeMethod() {goToUrl(ApplicationConstants.APP_URL_ELEMENTS_CHECK_BOX);}

   @AfterMethod
   public void afterMethod(){driver.quit();}

   //this test won't work because of incorrect values
   @Test
   public void checkboxTest(){
      CheckBoxsPage checkBoxsPage = new CheckBoxsPage(driver);
      checkBoxsPage.openMenuAndFillAllCheckboxes()
              .getChoosenPointNameInPointsTree();
      Assert.assertEqualsNoOrder(
              checkBoxsPage.getSelectedPointsList(),
              checkBoxsPage.getChoosenPointNameInPointsTree());
   }
   @Test
   public void oneCheckboxTest() {
      CheckBoxsPage checkBoxsPage = new CheckBoxsPage(driver);
      checkBoxsPage.clickDropDownArrow()
              .clickDescktopPoint()
              .clickDropDownArrow();
      Assert.assertEquals(checkBoxsPage.getSelectedCategoriesSecondGroup(), checkBoxsPage.getSelectedPointsList());
   }


}

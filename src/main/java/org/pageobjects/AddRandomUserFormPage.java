package org.pageobjects;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class AddRandomUserFormPage extends BasePage {
    Faker faker = new Faker();
    Random random = new Random();

    public AddRandomUserFormPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "#gender-radio-1")
    private WebElement genderMale;
    @FindBy(css = "#firstName")
    private WebElement firstName;
    @FindBy(css = "#lastName")
    private WebElement lastName;
    @FindBy(css = "#userEmail")
    private WebElement userEmail;
    @FindBy(css = "#age")
    private WebElement age;
    @FindBy(css = "#salary")
    private WebElement salary;
    @FindBy(css = "#department")
    private WebElement departmanet;
    @FindBy(css = "#submit")
    private WebElement submetBtn;

    public AddRandomUserFormPage generateRandomPersonShort(){
        waitElement(firstName);
        firstName.sendKeys(faker.name().firstName().toString());
        lastName.sendKeys(faker.name().lastName().toString());
        userEmail.sendKeys(faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com");
        age.sendKeys(String.valueOf(random.nextInt(90)));
        salary.sendKeys(String.valueOf(random.nextInt(10000)));
        departmanet.sendKeys(faker.funnyName().name().toString());
        submetBtn.click();
        return this;
    }

    private String getFakePhoneNumber(){return "050"+random.nextInt(1000001, 9999999);}
    private void selectGender(){genderMale.click();}

    public void selectHobbyCheckboxes(){
        List<WebElement> hobbyCheckboxes = new ArrayList<>();
        for(int i=1; i<hobbyCheckboxes.size(); i++){
            driver.findElement(By.cssSelector(" #hobbies-checkbox-"+ String.valueOf(i))).click();
        }
    }

    private void selectDateOfBirth(String day, String month, String year){
        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        WebElement dataPicker = driver.findElement(By.cssSelector(".react-datepicker"));
        dataPicker.findElement(By.cssSelector(".react-datepicker__month-dropdown-container--select")).click();
        selectFromDropdown(month, "month");
        selectFromDropdown(year, "year");
        selectDayOftheBirth(day);
    }
    private void selectFromDropdown(String valueOfChoose, String dataPickertype){
        driver.findElement(By.cssSelector("react-datepicker__"+dataPickertype+"-select")).click();
        List<WebElement> dropDownElements = driver.findElements(By.xpath("//*[@class='react-datepicker__"+dataPickertype+"-select']//."));
        for(WebElement element : dropDownElements){
            if(element.getText().equals(valueOfChoose)){
                element.click();
            }
        }
    }
    private void selectDayOftheBirth(String dayOfBirth){
        List<WebElement> days = driver.findElements(By.cssSelector(".react-datepicker__day"));
        for (WebElement element: days){
            if (element.getText().equals(dayOfBirth)){
                element.click();
            }
        }
    }
    private Map<String, String> generateUserDataFull(){
        Map<String, String> userData = new HashMap<>();
        userData.put("userName", faker.name().firstName().toString());
        userData.put("lastName", faker.name().lastName().toString());
        userData.put("userEmail", faker.name().firstName().toString()+faker.name().lastName().toString()+"@i.com");
        userData.put("mobileNumber", "050"+random.nextInt(1000001, 9999999));
        userData.put("subject", faker.funnyName().name().toString());
        return userData;
    }

}

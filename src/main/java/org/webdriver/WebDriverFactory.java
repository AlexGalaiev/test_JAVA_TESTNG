package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static webdriver.WebDriverType.CHROME_DRIVER;
import static webdriver.WebDriverType.FIREFOX_DRIVER;

public class WebDriverFactory {
    public static WebDriver getDriver(WebDriverType webDriverType) {
        WebDriver driver;
        switch (webDriverType) {
            case CHROME_DRIVER:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX_DRIVER:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + webDriverType);
        }
        driver.manage().window().maximize();
        return driver;
    }
}

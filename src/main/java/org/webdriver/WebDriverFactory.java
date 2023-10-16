package org.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.constants.ApplicationConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.webdriver.WebDriverType;

import org.webdriver.WebDriverType.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
            case CHROME_DRIVER_FOR_DOWLODS:
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefsMap = new HashMap<>();
                prefsMap.put("profile.default_content_settings.popups", 0);
                prefsMap.put("download.default.directory", ApplicationConstants.FILE_DOWNLOAD_FOLDER.getAbsolutePath());
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", prefsMap);
                options.addArguments("--test-type");
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);

            default:
                throw new IllegalStateException("Unexpected value: " + webDriverType);
        }
        driver.manage().window().maximize();
        return driver;
    }
}

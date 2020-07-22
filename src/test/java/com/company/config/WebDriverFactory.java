package com.company.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class WebDriverFactory {


    public static WebDriver createDriver() {
        Browser browserType = Browser.valueOf(WebDriverConfig.browser().toUpperCase());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        FirefoxOptions ffoptions = new FirefoxOptions();
        ffoptions.setProfile(new FirefoxProfile());
        ffoptions.addPreference("dom.webnotifications.enabled", false);
        switch (browserType) {
            case CHROME:
                return new ChromeDriver(options);
            case FIREFOX:
                return new FirefoxDriver(ffoptions);
            default:
                throw new UnsupportedBrowserException(browserType.name());
        }
    }
}

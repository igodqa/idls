package com.company.config;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.company.config.Browser.CHROME;


public class WebDriverConfig {

    private static final String browser = System.getProperty("browser", CHROME.name().toLowerCase());

    public static void load() {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        switch (browserType) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            default:
                throw new UnsupportedBrowserException(browser);
        }
    }

    public static String browser() {
        return browser;
    }

}

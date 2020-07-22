package com.company.infrastructure;

import com.company.config.WaitsOptions;
import com.company.config.WebDriverConfig;
import com.company.config.WebDriverFactory;
import com.company.infrastructure.logger.StdTestLogger;
import com.company.infrastructure.logger.TestLogger;
import com.company.pages.WebSite;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class TestBase {

    protected TestLogger logger;
    protected static WebDriver driver;
    protected WaitsOptions waitsOptions;
    private static final String email = System.getProperty("email");
    private static final String pass = System.getProperty("pass");
    public static String email() {
        return email;
    }
    public static String pass() {
        return pass;
    }
    private WebSite webSite;

    @BeforeClass
    public static void setUpDriver() {
        WebDriverConfig.load();
    }

    @Before
    public void setUp() {
        logger = new StdTestLogger();
        driver = WebDriverFactory.createDriver();
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
        waitsOptions = new WaitsOptions(driver);
        logger.log("- Start " + driver + " browser");
        logger.log("- Open the web-site");
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        logger.log("- Close " + driver + " browser");
        driver.quit();
    }
}

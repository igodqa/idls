package com.company.uitests;

import com.company.infrastructure.TestBase;
import com.company.pages.WebSite;
import org.junit.Assert;
import org.junit.Test;

public class WebSiteTests extends TestBase {

    private static WebSite webSite;

    @Test
    public void logoutTest(){
        webSite = new WebSite(driver);
        logger.log("- Open login page");
        webSite.signInLink().click();
        logger.log("- Log In");
        WebSite.logIn(email(),pass());
        logger.log("- Log out");
        webSite.signOutLink().click();
        logger.log("- Verify log out");
        Assert.assertTrue("Logout failed!", webSite.signInLink().isDisplayed());

    }


}

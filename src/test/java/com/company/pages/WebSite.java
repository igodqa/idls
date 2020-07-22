package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebSite {

    private static WebDriver driver;

    public WebSite(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement signInLink(){
        return driver.findElement(By.cssSelector(".login"));

    }

    public WebElement signOutLink(){
        return driver.findElement(By.cssSelector(".logout"));
    }

    public static void logIn(String email, String pass){
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("passwd")).sendKeys(pass);
        driver.findElement(By.id("SubmitLogin")).click();
    }


}

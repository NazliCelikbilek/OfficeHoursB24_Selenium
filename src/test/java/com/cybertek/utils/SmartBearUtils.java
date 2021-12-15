package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SmartBearUtils {

    public static void loginToSmartBear(WebDriver driver) {
        WebElement userName = driver.findElement(By.name("ctl00$MainContent$username"));
        WebElement passWord = driver.findElement(By.name("ctl00$MainContent$password"));
        WebElement loginBtn = driver.findElement(By.name("ctl00$MainContent$login_button"));

        userName.sendKeys("Tester");
        passWord.sendKeys("test");
        loginBtn.click();

        Assert.assertEquals(driver.getTitle(),"Web Orders","Failed to loin to smartbear app");

    }
    public static void addProduct (WebDriver driver){
        /**
         * TODO:
         */
    }
}

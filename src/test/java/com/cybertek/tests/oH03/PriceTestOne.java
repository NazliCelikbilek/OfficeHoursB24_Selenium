package com.cybertek.tests.oH03;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PriceTestOne {
    String url = "http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx";
    WebDriver driver; //can use in every method

    /**
     * Test Case 1:
     * Total Order Price Calculation 1
     * - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     * - Login with username: Tester, password: test
     * - Click  Order button
     * - Verify under Product Information, selected option is “MyMoney”
     * -Then select FamilyAlbum, make quantity 2, and click Calculate,
     * - Then verify Total is equal to Quantity*PricePerUnit
     * */

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(url);
    }

    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }

    @Test
    public void testOne() throws InterruptedException {
        //Login with username: Tester, password: test
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test"+ Keys.ENTER);

        driver.findElement(By.linkText("Order")).click();
        //Verify under Product Information, selected option is “MyMoney”

        Select dropdown =new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));

        String expectedText="MyMoney";
        String actualText   =dropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualText,expectedText,"Text do not match");

        //Then select FamilyAlbum, make quantity 2, and click Calculate,
        dropdown.selectByVisibleText("FamilyAlbum");
        WebElement quantityBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));


//        int quantity =2;
//        quantityBox.clear();
//        quantityBox.sendKeys(""+quantity);

        quantityBox.sendKeys(Keys.DELETE+"2");
        Thread.sleep(2000);

        WebElement pricePerUnitElement =driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        int pricePerUnit=Integer.parseInt(pricePerUnitElement.getAttribute("value"));
        System.out.println("pricePerUnit = " + pricePerUnit);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).click();
        //ctl00_MainContent_fmwOrder_txtUnitPrice
        int expectedTotalPrice=2*pricePerUnit;
        int actualTotalPrice =Integer.parseInt(driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getAttribute("value"));


        System.out.println("expectedTotalPrice = " + expectedTotalPrice);
        System.out.println("actualTotalPrice = " + actualTotalPrice);

        Assert.assertEquals(actualTotalPrice,expectedTotalPrice,"The Price DO NOT match");
    }

}

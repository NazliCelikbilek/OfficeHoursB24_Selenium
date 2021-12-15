package com.cybertek.tests.oH02;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class SmartBearTask {
    /**
     * Test Case 1:
     * Total Order Price Calculation 1
     * - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
     * - Login with username: Tester, password: test
     * - Click  Order button
     * - Verify under Product Information, selected option is “MyMoney”
     * -Then select FamilyAlbum, make quantity 2, and click Calculate,
     * - Then verify Total is equal to Quantity*PricePerUnit
     * Test Case 2:
     * Total Order Price Calculation 2
     * - Go to https://www.demoblaze.com/index.html#
     * - From Categories select Laptops, and from products select Sony Vaio i7
     * - click Add to Cart then handle pop up
     * - Navigate to Home
     * - From Categories select Phones, and from products select Iphone 6 32gb
     * - click Add to Cart then handle pop up
     * - Navigate to Cart
     * - Then Verify that total cart price is equal to expected (total of added 2 items) price
     * Hope to see you all and hope to have a productive time together.
     */
    @Test
    public void loginTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // page title before login

        String expectedTitle = "Web orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test" + Keys.ENTER);

//    WebElement loginBtn =driver.findElement(By.cssSelector("#ctl00_MainContent_login_button"));
//  loginBtn.click(); this is same with =====> +Keys.ENTER

        //check the title after login

        String expectedTitleAfterLogin = "Web Orders";
        String actualTitleAfterLogin = driver.getTitle();

        System.out.println(expectedTitleAfterLogin.equalsIgnoreCase(actualTitleAfterLogin));

        Thread.sleep(2000);
        //  driver.close();
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        // page title before login

        String expectedTitle = "Web orders Login";
        String actualTitle = driver.getTitle();
        System.out.println(expectedTitle.equalsIgnoreCase(actualTitle));

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement passWord = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        passWord.sendKeys("test" + Keys.ENTER);

        WebElement checkAllBtn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();

        List<WebElement> allCheckBoxes = driver.findElements(By.cssSelector("#input[type='checkbox']"));
        for (WebElement eachCheckBox : allCheckBoxes) {
            if (eachCheckBox.isSelected() != true) {
                System.out.println("Not all selected");// in Test NG we will learn assertions for these situations
                break;
            }

        }


        WebElement uncheckAllButton = driver.findElement(By.id("ctl00_MainContent_btnUncheckAll"));
        uncheckAllButton.click();

        allCheckBoxes = driver.findElements(By.cssSelector("#input[type='checkbox']"));

        for (WebElement eachCheckBox : allCheckBoxes) {
            if (eachCheckBox.isSelected() == true) {
                System.out.println("Not all checkboxes unselected");
                break;


            }
        }


        WebElement  itemForDeleting=driver.findElement(By.xpath("//tr//td[.='Paul Brown']/../td[1]/input"));
        itemForDeleting.click();

        allCheckBoxes = driver.findElements(By.cssSelector("#input[type='checkbox']"));
        System.out.println("Before I delete = " + allCheckBoxes.size());


        Thread.sleep(3000);
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
        System.out.println("After I delete = " + allCheckBoxes.size());
    }
}


package com.cybertek.tests.oH01;

import com.cybertek.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PolymerTest {
    /**
     * Here is this week`s task:
     * Write a basic browser automation framework to validate a Polymer website.
     * The focus should be on the interaction with the browser.
     * The web Application under test https://todomvc.com/
     * The fist step should be to load the website,
     * click within the Javascript tab,
     * and select the Polymer Link
     * THe second step should be : Add one Todo item
     * Then Verify that the item added
     */

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //The fist step should be to load the website https://todomvc.com/
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        String url = "https://todomvc.com/";
        driver.get(url);

        //click within the javaScript tab
       /* WebElement tabLink = driver.findElement(By.xpath("//div[.='JavaScript']"));
        tabLink.click();*/

        getTab("JavaScript").click();

        //select the  polymer link
        /** WebElement link = driver.findElement(By.linkText("Polymer"));
         link.click();*/
        getLink("Polymer").click();

        //THe second step should be : Add one Todo item
        WebElement addBox = driver.findElement(By.id("new-todo"));

        String todoItemOne = "Office Hours B24";
        addBox.sendKeys(todoItemOne + Keys.ENTER);

        String locatorForAddedItem = "//label[.='" + todoItemOne + "']";
        //string concatenation : "//label[.='"+todoItemOne+"']"

        //"apple"+variable+"banana"

        // Then Verify that the item added

        System.out.println("Verify the item added " + driver.findElement(By.xpath(locatorForAddedItem)).isDisplayed());

       Thread.sleep(2000);
        driver.close();
    }

    public static WebElement getTab(String tab) {
        String locator = "//div[.='" + tab + "']";
        return driver.findElement(By.xpath(locator));
    }

    public static WebElement getLink(String link) {

        return driver.findElement(By.linkText(link));
    }
}
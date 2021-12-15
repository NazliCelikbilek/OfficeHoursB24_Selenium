package com.cybertek.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class OfficeUtils {

    //create a static method, with accept String will return web element, getLink(String str)

    public static WebElement getLink(String str) {
        return Driver.getDriver().findElement(By.partialLinkText(str));
    }

    // addProduct(String category,String product),return an integer value which is product price
    // alsa add the product to my Card
    public static int addProduct(String category, String product) {
        getLink(category).click();
        getLink(product).click();

        //getting the product`s price
        WebElement priceContainer = Driver.getDriver().findElement(By.xpath("//h3"));
        int productPrice = Integer.parseInt(priceContainer.getText().substring(1, 4));

    }


}

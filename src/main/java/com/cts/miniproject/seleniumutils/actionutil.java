package com.cts.miniproject.seleniumutils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class actionutil {
    public static void enterkey(WebDriver driver){

        Actions a = new Actions(driver);

        a.sendKeys(Keys.ENTER).perform();

    }

}

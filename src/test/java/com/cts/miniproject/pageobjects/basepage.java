package com.cts.miniproject.pageobjects;

import org.openqa.selenium.WebDriver;

public class basepage {
    WebDriver driver;

    public basepage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

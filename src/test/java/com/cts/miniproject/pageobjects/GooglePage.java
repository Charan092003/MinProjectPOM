package com.cts.miniproject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {
    WebDriver driver;
    //constructor
    public GooglePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(id = "APjFqb")
    static WebElement txt_searchbox;

    //actions
    public void setSearchBox(String searchtext){
        txt_searchbox.sendKeys(searchtext);
    }



}

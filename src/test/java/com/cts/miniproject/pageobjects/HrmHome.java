package com.cts.miniproject.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrmHome {
    WebDriver driver;

    public HrmHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //Locators
    @FindBy(xpath = "//div[2]/ul/li[2]/a/button")
    WebElement btn_contactsales;

    //actions
    public void clickContactSales(){
        btn_contactsales.click();
    }
}

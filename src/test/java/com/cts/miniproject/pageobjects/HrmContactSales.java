package com.cts.miniproject.pageobjects;

import com.cts.miniproject.frameworkutil.commonutils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HrmContactSales extends basepage {
    WebDriver driver;
    WebDriverWait wait;

    //constructor
    public HrmContactSales(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators

    //name
    @FindBy(id = "Form_getForm_FullName")
    WebElement txt_name;

    //phoneno
    @FindBy(id = "Form_getForm_Contact")
    WebElement txt_phoneNo;

    //email
    @FindBy(id = "Form_getForm_Email")
    WebElement txt_email;

    //country dropdown
    @FindBy(id = "Form_getForm_Country")
    WebElement dropdown_country;

    //employee drop down
    @FindBy(id = "Form_getForm_NoOfEmployees")
    WebElement dropdown_employee;

    //job title
    @FindBy(id = "Form_getForm_JobTitle")
    WebElement txt_job;

    //frame for robot
    @FindBy(xpath = "//div[@id='Nocaptcha-Form_getForm_Captcha']/div/div/iframe")
    WebElement frame_robot;

    //robot button
    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    WebElement btn_robot;

    //submit btn
    @FindBy(id = "Form_getForm_action_submitForm")
    WebElement btn_submit;

    //message
    @FindBy(id = "Form_getForm_Comment")
    WebElement txt_message;

    //Actions
    public void setName(String name) {
        txt_name.sendKeys(name);
    }

    public void setPhoneNo(String phno) {
        txt_phoneNo.sendKeys(phno);
    }

    public void setEmail(String email) {
        txt_email.sendKeys(email);
    }

    public void setCountry(String country) {
        Select s = new Select(dropdown_country);
        s.selectByVisibleText(country);
    }

    public void setEmployee(String employee) {
        Select s = new Select(dropdown_employee);
        s.selectByVisibleText(employee);
    }

    public void setJob(String job) {
        txt_job.sendKeys(job);
    }

    public void clickRobot() {
        wait = new WebDriverWait(driver, Duration.ofMinutes(3));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame_robot));
        wait.until(ExpectedConditions.elementToBeClickable(btn_robot)).click();
        commonutils.surewait(3);
        driver.switchTo().defaultContent();

    }




    public void setMessgae(String messgae) {
        txt_message.sendKeys(messgae);
    }

    public void clickSubmit() {
        btn_submit.click();
    }

    public void clickSubmitInNewTab() {
        Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL).click(btn_submit).keyUp(Keys.CONTROL).perform();
        commonutils.surewait(1);
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
    }

    @Override
    public String getPageTitle() {
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        return driver.getTitle();
    }

}

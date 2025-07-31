package com.cts.miniproject.testrunners;

import com.cts.miniproject.frameworkutil.commonutils;
import com.cts.miniproject.pageobjects.GooglePage;
import com.cts.miniproject.pageobjects.HrmContactSales;
import com.cts.miniproject.pageobjects.HrmHome;
import com.cts.miniproject.pageobjects.HrmThankYou;
import com.cts.miniproject.seleniumutils.actionutil;
import com.cts.miniproject.seleniumutils.screenshotutil;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MiniProjectTest {

    WebDriver driver;

    @BeforeMethod
    public void init() throws FileNotFoundException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

    }

    @Test(dataProvider = "datamethod")
    public void testcases() {
        //entering text in google search box
        GooglePage gp = new GooglePage(driver);
        gp.setSearchBox("Orange Hrm Demo");

        //pressing enter key
        actionutil.enterkey(driver);

        //moving back forward and going to orange hrm page
        WebDriver.Navigation n = driver.navigate();
        commonutils.surewait(1);
        n.to("https://www.orangehrm.com/");
        n.back();
        commonutils.surewait(2);
        n.forward();


        //clicking contact sales
        HrmHome hhome = new HrmHome(driver);
        hhome.clickContactSales();

        //passing all the form values
        HrmContactSales hcontact = new HrmContactSales(driver);
        hcontact.setName("Vikram Rathode");
        hcontact.setPhoneNo("1234567890");
        hcontact.setEmail("rathodeitsolutions@gmail.com");
        hcontact.setCountry("India");
        hcontact.setEmployee("11 - 50");
        hcontact.setJob("Fresher");
        hcontact.clickRobot();

        commonutils.surewait(20);


        //clicking submit taking screenshot and clicking again
        hcontact.clickSubmit();
        commonutils.surewait(2);
        screenshotutil.takescreenshot(driver);
        hcontact.setMessgae("Hello this is a test");
        hcontact.clickSubmitInNewTab();
        commonutils.surewait(4);


        HrmThankYou hthanks = new HrmThankYou(driver);
        String thanksTitle = hthanks.getPageTitle();
        System.out.println(thanksTitle);
        commonutils.surewait(2);
        commonutils.closeBrowser(driver);


        String contactTitle = hcontact.getPageTitle();
        System.out.println(contactTitle);




        Assert.assertNotEquals(contactTitle, thanksTitle, "Error did not switch");

    }

    @AfterMethod
    public void endit() {
        driver.close();
    }

}

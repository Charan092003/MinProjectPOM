package com.cts.miniproject.seleniumutils;

import com.cts.miniproject.frameworkutil.commonutils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class screenshotutil {

    public static void takescreenshot(WebElement element){
        TakesScreenshot tss = (TakesScreenshot)element;
        File src = tss.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/"+ commonutils.getCurrentDate()+".png");

        try{
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void takescreenshot(WebDriver driver) {

        TakesScreenshot tss = (TakesScreenshot)driver;
        File src = tss.getScreenshotAs(OutputType.FILE);
        File dest = new File("screenshots/"+ commonutils.getCurrentDate()+".png");

        try{
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}

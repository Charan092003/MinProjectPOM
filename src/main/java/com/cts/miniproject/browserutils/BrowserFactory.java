package com.cts.miniproject.browserutils;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

import java.net.URL;

import java.time.Duration;

public class BrowserFactory {

    private static WebDriver driver;

    private static WebDriver runLocal(String browsername) {

        switch (browsername.intern().toLowerCase()) {

            case "chrome":

                driver = new ChromeDriver();

                break;

            case "edge":

                driver = new EdgeDriver();

                break;

        }

        return driver;

    }

    private static WebDriver runRemote(String browsername, String hip) throws MalformedURLException {


        DesiredCapabilities dc = new DesiredCapabilities();

        dc.setBrowserName(browsername);

        switch (browsername.intern().toLowerCase()) {

            case "chrome":

                driver = new RemoteWebDriver(new URL(hip + "/wd/hub"), dc);

                break;

            case "edge":

                driver = new RemoteWebDriver(new URL(hip + "/wd/hub"), dc);

                break;

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;

    }

    public static WebDriver getBrowser(String browsername, String wr, String hip) throws MalformedURLException {

        if (wr.intern().equalsIgnoreCase("cloud")) {

            driver = runRemote(browsername, hip);

        } else {

            driver = runLocal(browsername);

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        System.out.println(browsername);

        System.out.println(wr);

        System.out.println(hip);

        return driver;

    }

    public static WebDriver getBrowser(String browsername, String url){

        switch (browsername.intern().toLowerCase()){

            case "chrome":

                driver = new ChromeDriver();

                break;

            case "edge":

                driver = new EdgeDriver();

                break;

            default:

                ChromeOptions co = new ChromeOptions();

                co.addArguments("--headless");

                driver = new ChromeDriver(co);

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.get(url);

        return driver;

    }

    public static WebDriver getDriver(String browsername) {

        switch (browsername.intern().toLowerCase()){

            case "chrome":

                driver = new ChromeDriver();

                break;

            case "edge":

                driver = new EdgeDriver();

                break;

            default:

                ChromeOptions co = new ChromeOptions();

                co.addArguments("--headless");

                driver = new ChromeDriver(co);

        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        return driver;

    }


    public static WebDriver getBrowser() throws NullPointerException {

        return driver;

    }

    public static void Openurl(String url){

        driver.get(url);

    }


}



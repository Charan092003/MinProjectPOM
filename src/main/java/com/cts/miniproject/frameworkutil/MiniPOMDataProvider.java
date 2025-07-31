package com.cts.miniproject.frameworkutil;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;


public class MiniPOMDataProvider {
    @DataProvider(name = "datamethod")
    public static String[][] data(Method testCases){
        String [][] s = null;
        return s;

    }

}

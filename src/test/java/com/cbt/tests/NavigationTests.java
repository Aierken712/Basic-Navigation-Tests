package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://Google.com");
        String title = "Google";
        BrowserFactory.wait(2);

        driver.navigate().to("https://etsy.com");
        String title2 = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        BrowserFactory.wait(2);

        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");
        BrowserFactory.wait(2);

        driver.navigate().forward();
        verifyEquals(driver.getTitle(),"Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone");


        BrowserFactory.wait(2);
        driver.close();

    }

    public static void verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("TEST PASSED!");
        }else{
            System.out.println("TEST FAILED!");
        }
    }


}

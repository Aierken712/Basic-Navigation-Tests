package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    /**
     * This method return WebDriver object based on browser type
     * if you want to use chrome browser, just provide chrome as a parameter
     * @param browserName
     * @return WebDriver object
     */
    public static WebDriver getDriver(String browserName){

        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserName.equalsIgnoreCase("Edge")){
            WebDriverManager.chromedriver().setup();
            return new EdgeDriver();
        }else{
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }

    }

    public static void wait(int seconds) {

        try{
            Thread.sleep(1000*seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

}

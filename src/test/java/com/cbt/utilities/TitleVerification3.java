package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com/", "https://westelm.com/");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i=0;i<urls.size();i++){
            driver.get(urls.get(i));
            BrowserFactory.wait(2);

            if( urls.get(i).contains(driver.getTitle()) ){
                System.out.println("Test Pass");
            }else{
                System.out.println("Test Fail");
            }
        }

        BrowserFactory.wait(2);

        for(String each : urls){
           driver.get(each);
            BrowserFactory.wait(2);
            driver.navigate().back();
        }

        driver.close();

    }
}

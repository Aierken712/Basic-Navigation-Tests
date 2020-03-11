package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for(int i=0;i<urls.size();i++){
            driver.get(urls.get(i));
            BrowserFactory.wait(2);
            StringUtility.verifyEquals(driver.getTitle(),"Practice");
        }

        String s1 = urls.get(0);
        String s2 = urls.get(1);
        String s3 = urls.get(2);

        if(s2.startsWith(s1) && s3.startsWith(s1)){
            System.out.println("Test Pass");
        }else{
            System.out.println("Test fail");
        }

        BrowserFactory.wait(1);
        driver.close();
    }
}

package com.cbt.tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_Eight {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test8(){

        WebElement link = driver.findElement(By.linkText("Autocomplete"));
        link.click();
        BrowserFactory.wait(2);

        WebElement countryInput = driver.findElement(By.id("myCountry"));
        countryInput.sendKeys("United States of America");
        WebElement submitBtn = driver.findElement(By.xpath("//input[@type='button']"));
        submitBtn.click();
        BrowserFactory.wait(2);

        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void teardown(){

        BrowserFactory.wait(2);
        driver.quit();
    }
}

package com.cbt.tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCase_NineToTwelve {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
    }

    @DataProvider(name = "testData")
    public static Object[] testData() {
        return new Object[]{"404", "500", "301", "200"};
    }

    @Test(dataProvider = "testData")
    public void statusCodes(String code) {

        WebElement statusCodeLink = driver.findElement(By.linkText("Status Codes"));
        statusCodeLink.click();

        WebElement statusCode = driver.findElement(By.linkText(code));
        statusCode.click();

        String expectedMessage = "This page returned a " + code + " status code";
        WebElement displayedMessageElement = driver.findElement(By.xpath("//p"));
        String actualMessage = displayedMessageElement.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "The status code does not exist");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}

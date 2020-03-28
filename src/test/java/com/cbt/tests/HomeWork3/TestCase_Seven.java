package com.cbt.tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_Seven {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){

        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void test7(){
        //step2
        WebElement fileUpload = driver.findElement(By.linkText("File Upload"));
        fileUpload.click();
        //step3
        //String filePath = System.getProperty("user.dir")+"/pom.xml";
        String file2Path = "C:\\Users\\ersha\\OneDrive\\Desktop\\new\\image (21).png";
        WebElement chooseBtn = driver.findElement(By.id("file-upload"));
        chooseBtn.sendKeys(file2Path);
        // step4
        BrowserFactory.wait(2);
        WebElement uploadBtn = driver.findElement(By.id("file-submit"));
        uploadBtn.click();
        //step5
        BrowserFactory.wait(2);
        String expected = "File Uploaded!";
        String actual = driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).getText();
        Assert.assertEquals(actual,expected);
        //step6
        BrowserFactory.wait(2);
        String expected2 = "image (21).png";
        String actual2 = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual2,expected2);
    }




    @AfterMethod
    public void teardown(){

      driver.quit();
    }
}

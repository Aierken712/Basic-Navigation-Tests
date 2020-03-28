package com.cbt.tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_Six {

    private WebDriver driver;
    private String URL = "https://www.tempmailaddress.com/";
    private String URL2 = "https://practice-cybertekschool.herokuapp.com/";
    private By signUpForMailingListBy = By.linkText("Sign Up For Mailing List");
    private By fullNameBy = By.name("full_name");
    private By emailBy = By.name("email");
    private By signUpBy = By.name("wooden_spoon");
    private By textBy = By.xpath("//h3");
    //private By longTextBy = By.xpath("//tbody[@id='schranka']/tr[3]/td[1]/span[2]");
    private By fromBy = By.xpath("(//td[@class='from'])[1]");
    private By emailTextBy = By.xpath("//td[text()='Thanks for subscribing to practice.cybertekschool.com!']");
    private By subjectTextBy = By.id("//span[@id='odesilatel']");
    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void testCase_6(){

        String email = driver.findElement(By.id("email")).getText();
        driver.navigate().to(URL2);
        driver.findElement(signUpForMailingListBy).click();
        BrowserFactory.wait(2);

        driver.findElement(fullNameBy).sendKeys("testuser");
        BrowserFactory.wait(1);

        driver.findElement(emailBy).sendKeys(email);
        BrowserFactory.wait(1);

        driver.findElement(signUpBy).click();
        BrowserFactory.wait(1);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(textBy).getText();
        Assert.assertEquals(actual,expected);

        driver.navigate().to("https://www.tempmailaddress.com/");

        String expected2 = "do-not-reply@practice.cybertekschool.com";
        String actual2 = driver.findElement(fromBy).getText();
        Assert.assertEquals(actual2,expected2);

        driver.findElement(fromBy).click();

        String expected3 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actual3 = driver.findElement(emailTextBy).getText();
        Assert.assertEquals(actual3,expected3);

        String expected4 = "Thanks for subscribing to practice.cybertekschool.com!";
        String actual4 = driver.findElement(subjectTextBy).getText();
        Assert.assertEquals(actual4,expected4);

    }

    @AfterMethod
    public void teardown(){

        BrowserFactory.wait(2);
        driver.close();

    }


}

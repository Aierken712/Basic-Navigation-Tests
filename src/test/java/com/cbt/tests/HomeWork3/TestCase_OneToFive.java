package com.cbt.tests.HomeWork3;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class TestCase_OneToFive {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private By registrationFormBy = By.linkText("Registration Form");
    private By dateOfBirthBtnBy = By.xpath("//input[@name='birthday']");
    private By dateOfBirthNotValidBy = By.xpath("//small[@style='display: block;']");
    private By cPlusPlusBy = By.xpath("//input[@id='inlineCheckbox1']");
    private By javaBy = By.xpath("//input[@id='inlineCheckbox2']");
    private By javaScriptBy = By.xpath("//input[@id='inlineCheckbox3']");
    private By firstNameLocatorBy = By.xpath("//input[@name='firstname']");
    private By firstNameTextBy = By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
    private By lastNameLocatorBy = By.xpath("//input[@name='lastname']");
    private By lastNameTextBy = By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");

    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");

    //private By genderBy = By.cssSelector("(//label[@class='col-sm-3 control-label'])[7]");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By dateOfBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");

    private By signUpBy = By.id("wooden_spoon");
    private By textBy = By.tagName("p");


    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @Test
    public void testCase_1(){

        driver.findElement(registrationFormBy).click();
        BrowserFactory.wait(2);

        driver.findElement(dateOfBirthBtnBy).sendKeys("wrong_dob");
        BrowserFactory.wait(2);

        String expected = "The date of birth is not valid";
        String actual = driver.findElement(dateOfBirthNotValidBy).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testCase_2(){

        driver.findElement(registrationFormBy).click();
        BrowserFactory.wait(3);

        WebElement cPlusPlus = driver.findElement(cPlusPlusBy);
        Assert.assertTrue(cPlusPlus.isDisplayed());
        BrowserFactory.wait(2);

        WebElement java = driver.findElement(javaBy);
        Assert.assertTrue(java.isDisplayed());
        BrowserFactory.wait(2);

        WebElement javaScript = driver.findElement(javaScriptBy);
        Assert.assertTrue(javaScript.isDisplayed());
        BrowserFactory.wait(2);

    }

    @Test
    public void testCase_3(){

        driver.findElement(registrationFormBy).click();
        BrowserFactory.wait(3);

        driver.findElement(firstNameLocatorBy).sendKeys("f");
        BrowserFactory.wait(3);

        String expected = "first name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(firstNameTextBy).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testCase_4(){

        driver.findElement(registrationFormBy).click();
        BrowserFactory.wait(3);

        driver.findElement(lastNameLocatorBy).sendKeys("l");
        BrowserFactory.wait(3);

        String expected = "The last name must be more than 2 and less than 64 characters long";
        String actual = driver.findElement(lastNameTextBy).getText();
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void testCase_5(){

        driver.findElement(registrationFormBy).click();
        BrowserFactory.wait(3);

        driver.findElement(firstNameBy).sendKeys("Patrick");
        driver.findElement(lastNameBy).sendKeys("White");
        driver.findElement(usernameBy).sendKeys("testuser");
        driver.findElement(emailBy).sendKeys("test@gmail.com");
        driver.findElement(passwordBy).sendKeys("123456789");
        driver.findElement(phoneBy).sendKeys("354-524-8965");
        BrowserFactory.wait(1);

        driver.findElement(maleBy).click();
        BrowserFactory.wait(2);

        driver.findElement(dateOfBirthBy).sendKeys("07/12/1989");
        BrowserFactory.wait(2);

        Select departmentSelect = new Select(driver.findElement(departmentBy));
        List<WebElement> options = departmentSelect.getOptions();
        for (WebElement option : options) {
            BrowserFactory.wait(1);
            departmentSelect.selectByVisibleText(option.getText());
        }
        BrowserFactory.wait(2);

        Select job = new Select(driver.findElement(jobTitleBy));
        List<WebElement> jobs = job.getOptions();
        for (WebElement element : jobs) {
            BrowserFactory.wait(1);
            job.selectByVisibleText(element.getText());

        }
        BrowserFactory.wait(2);

        driver.findElement(javaBy).click();
        BrowserFactory.wait(2);

        driver.findElement(signUpBy).click();
        BrowserFactory.wait(2);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(textBy).getText();
        Assert.assertEquals(actual,expected);
    }

    @AfterMethod
    public void teardown(){

        BrowserFactory.wait(3);
        driver.close();
    }

}

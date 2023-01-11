package com.cydeo.tests.day5_TestNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T7_NonselectDropdown {

    WebDriver driver;

            //TC #7: Selecting value from non-select dropdown
            //1. Open Chrome browser
            //2. Go to https://practice.cydeo.com/dropdown
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
            //3. Click to non-select dropdown


    @Test
    public void clickDropdown(){
        WebElement dropdown = driver.findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropdown.click();


            //4. Select Facebook from dropdown

        WebElement faceOption = driver.findElement(By.xpath("//a[@href='https://www.facebook.com/']"));
        faceOption.click();


            //5. Verify title is “Facebook - Log In or Sign Up”

        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

    }
    @AfterMethod
    public void tearDownMethod(){
        //driver.close();
    }
}

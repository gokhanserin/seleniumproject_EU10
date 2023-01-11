package com.cydeo.tests.day6_alerts_iframes_windows;


import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T2_AlertPractice {

    WebDriver driver;

    //TC #2: Confirmation alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    //3. Click to “Click for JS Confirm” button

    @Test
    public void click(){
        WebElement clickJsConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickJsConfirm.click();

        //4. Click to OK button from the alert

        Alert alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You clicked: Ok” text is displayed.

        String expectedText = "You clicked: Ok";
        String actualText = driver.findElement(By.xpath("//p[.='You clicked: Ok']")).getText();

        Assert.assertEquals(actualText,expectedText, "Actual result test is not as expected!!!");

        //Assert.assertTrue(actualText.equals(expectedText));


    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }





}

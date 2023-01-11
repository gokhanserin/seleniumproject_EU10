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

public class T3_AlertPractice {

    WebDriver driver;

    //TC #3: Information alert practice
    //1. Open browser
    //2. Go to website: http://practice.cydeo.com/javascript_alerts

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }

    @Test
    public void click(){

        //3. Click to “Click for JS Prompt” button

        WebElement clickCsPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickCsPrompt.click();

        //4. Send “hello” text to alert

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert

        alert.accept();

        //6. Verify “You entered:  hello” text is displayed.
        String expectedText = "You entered:  hello";
        String actualText = driver.findElement(By.xpath("//p[.='You entered: hello']")).getText();

        Assert.assertEquals(actualText,expectedText);

    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}

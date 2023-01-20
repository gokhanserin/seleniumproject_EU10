package com.cydeo.tests.day8_properties_config_reader.ExtraTasks;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T1_SmartBear {

    public WebDriver driver;

    //TC #1: Smartbear software link verification
    //1. Open browser

    @BeforeMethod
    public void setUpMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void linkVerification(){

        //2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        //3. Enter username: “Tester”

        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        inputUsername.sendKeys("Tester");

        //4. Enter password: “test”

        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        inputPassword.sendKeys("test");

        //5. Click to Login button

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        //6. Print out count of all the links on landing page

        List<WebElement> allTheLinks = driver.findElements(By.tagName("a"));

        System.out.println("allTheLinks.size() = " + allTheLinks.size());

        //7. Print out each link text on this page

        for (WebElement each : allTheLinks) {
            System.out.println("each.getText() = " + each.getText());
        }

    }

    @Test
    public void login(){

        SmartBearUtils. loginToSmartBear (driver); // This method can be used instead of the steps 2-5 above

    }

}

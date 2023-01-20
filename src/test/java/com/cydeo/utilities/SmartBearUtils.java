package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SmartBearUtils {

public static void  loginToSmartBear (WebDriver driver){


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
}


}

package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_locators_getText {

    public static void main(String[] args) {

       // WebDriverManager.chromedriver().setup();
       // WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        //driver.findElement(By.name("USER_LOGIN")).sendKeys("incorrect");
        WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        usernameBox.sendKeys("incorrect");

        // to auto generate local variable: Alt + enter
        WebElement passwordBox = driver.findElement(By.name("USER_PASSWORD"));
        passwordBox.sendKeys("incorrect");

        WebElement loginBox = driver.findElement(By.className("login-btn"));
        loginBox.click();

        String expextedMessage = "Incorrect login or password";
        String actualMessage = driver.findElement(By.className("errortext")).getText();

        if (actualMessage.equals(expextedMessage)){
            System.out.println("Error message is verified!");
        }else{
            System.out.println("Error message is NOT verified!");
        }


    }


}

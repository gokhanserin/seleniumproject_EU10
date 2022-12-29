package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://login1.nextbasecrm.com/");

        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";
        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label verification PASSED!");
        }else{
            System.out.println("Remember me label verification FAILED");
        }

        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLink = forgotPasswordLink.getText();

        String expectedForgotPasswordLink = "Forgot your password?";
        System.out.println(actualForgotPasswordLink);

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){
            System.out.println("Password link text verification PASSED!");
        }else{
            System.out.println("Password link text verification FAILED");
        }

        String actualForgotPasswordHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedForgotPasswordHrefValue = "forgot_password=yes";

        if (actualForgotPasswordHrefValue.equals(expectedForgotPasswordHrefValue)){
            System.out.println("Href value verification PASSED!");
        }else{
            System.out.println("Href value verification FAILED!");
        }


    }


}

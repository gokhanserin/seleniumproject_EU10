package com.cydeo.tests.day3_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();
        String expectedRememberMeLabel = "Remember me on this computer";
        if (actualRememberMeLabel.equals(expectedRememberMeLabel)){
            System.out.println("Remember me label verification PASSED!");
        }else{
            System.out.println("Remember me label verification FAILED");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        WebElement forgotPasswordLink = driver.findElement(By.className("login-link-forgot-pass"));
        String actualForgotPasswordLink = forgotPasswordLink.getText();

        String expectedForgotPasswordLink = "FORGOT YOUR PASSWORD?";
        System.out.println(actualForgotPasswordLink);
        System.out.println(expectedForgotPasswordLink);

        if (actualForgotPasswordLink.equals(expectedForgotPasswordLink)){
            System.out.println("Password link text verification PASSED!");
        }else{
            System.out.println("Password link text verification FAILED");
        }
        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes

        String actualForgotPasswordHrefValue = forgotPasswordLink.getAttribute("href");
        String expectedForgotPasswordHrefValue = "forgot_password=yes";

        if (actualForgotPasswordHrefValue.contains(expectedForgotPasswordHrefValue)){
            System.out.println("Href value verification PASSED!");
        }else{
            System.out.println("Href value verification FAILED!");
        }


    }


}

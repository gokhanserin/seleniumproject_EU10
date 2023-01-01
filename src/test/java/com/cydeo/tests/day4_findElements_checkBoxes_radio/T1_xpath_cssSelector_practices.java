package com.cydeo.tests.day4_findElements_checkBoxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practices {

    public static void main(String[] args) {

       // TC #1: XPATH and cssSelector Practices
       // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

       // 3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
       // a. “Home” link
            // Finding Web Element via cssSelector
        //WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        //WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        //WebElement homeLink = driver.findElement(By.cssSelector("a[href='/']"));
            // Finding web element via Xpath
        //WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        //WebElement homeLink = driver.findElement(By.xpath("//a[.='Home']"));
        WebElement homeLink = driver.findElement(By.xpath("//*[@href='/']"));

        // b. “Forgot password” header
        WebElement forgotPasswordHeader1 = driver.findElement(By.cssSelector("div.example>h2"));
        WebElement forgotPasswordHeader = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));

        // c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        WebElement emailText2 = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailText3 = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailText4 = driver.findElement(By.xpath("//*[@for='email']"));

        // d. E-mail input box
        WebElement emailInputBox = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement emailInputBox2 = driver.findElement(By.cssSelector("input[name='email']"));
        WebElement emailInputBox3 = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement emailInputBox4 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));
        WebElement emailInputBox5 = driver.findElement(By.xpath("//*[@type='text']"));

        // e. “Retrieve password” button
        WebElement retrievePasswordBtn = driver.findElement(By.xpath("//button[@id='form_submit']"));
        //WebElement retrievePasswordButton = driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        //WebElement retrievePasswordButton2 = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        //WebElement retrievePasswordButton3 = driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']"));
        //WebElement retrievePasswordButton4 = driver.findElement(By.xpath("//i[contains(@class,'icon-2x icon-signin')]"));
        //WebElement retrievePasswordButton5 = driver.findElement(By.xpath("//*[@class='icon-2x icon-signin']"));

        // f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        WebElement poweredByCydeoText2 = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        WebElement poweredByCydeoText3 = driver.findElement(By.xpath("//div[contains(@style,'text-align: center;')]"));
        WebElement poweredByCydeoText4 = driver.findElement(By.xpath("//*[@style='text-align: center;']"));

        // 4. Verify all web elements are displayed.
        boolean poweredByCydeoText2Displayed = poweredByCydeoText2.isDisplayed();
        System.out.println("poweredByCydeoText2Displayed = " + poweredByCydeoText2Displayed);
        System.out.println("emailInputBox2.isDisplayed() = " + emailInputBox2.isDisplayed());
        System.out.println("emailText.isDisplayed() = " + emailText.isDisplayed());
        System.out.println("forgotPasswordHeader1.isDisplayed() = " + forgotPasswordHeader1.isDisplayed());
        System.out.println("homeLink.isDisplayed() = " + homeLink.isDisplayed());
        System.out.println("retrievePasswordBtn.isDisplayed() = " + retrievePasswordBtn.isDisplayed());


    }


}

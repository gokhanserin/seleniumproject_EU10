package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test

    public void registration_form_test(){

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        // Driver.getDriver() --> driver
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        // Create JavaFaker object
        Faker faker = new Faker();

        //3. Enter first name
        //WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        WebElement inputFirstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        inputFirstName.sendKeys(faker.name().firstName());

        //4. Enter last name

        WebElement inputLastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        inputLastName.sendKeys(faker.name().lastName());

        //5. Enter username

        //inputUserName.sendKeys(faker.name().username().replaceAll(".",""));
        WebElement inputUserName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        String user = faker.bothify("helpdesk###");
        inputUserName.sendKeys(user);


        //6. Enter email address

        WebElement inputEmail = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        inputEmail.sendKeys(user + "@email.com");

        //7. Enter password

        WebElement inputPassword = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        inputPassword.sendKeys(faker.numerify("########"));
        //System.out.println("faker.internet().password() = " + faker.internet().password());

        //8. Enter phone number

        WebElement inputPhone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        inputPhone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons

        WebElement inputGender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        inputGender.click();

        //10. Enter date of birth

        WebElement inputBirthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        //faker.number().numberBetween(2004,1920);
        inputBirthday.sendKeys("03/08/2000");

        //11. Select Department/Office

        Select departmentDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        departmentDropdown.selectByIndex(faker.number().numberBetween(1,9));

        //12. Select Job Title

        Select jobTitleDropdown = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByIndex(faker.number().numberBetween(1,8));

        //13. Select programming language from checkboxes

        WebElement inputProgrammingLanguage = Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        inputProgrammingLanguage.click();

        //14. Click to sign up button

        WebElement signUpButton = Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']"));
        signUpButton.click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.

        //WebElement successMessage = Driver.getDriver().findElement(By.tagName("p"));
        //Assert.assertTrue(successMessage.isDisplayed());

        WebElement successMessage = Driver.getDriver().findElement(By.tagName("p"));
        String actualMessage = successMessage.getText();
        String expectedMessage = "You’ve successfully completed registration.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }



}

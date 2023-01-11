package com.cydeo.tests.day5_TestNG_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T8_MultipleSelectDropdown {

    WebDriver driver;

    // TC #8: Selecting value from multiple select dropdown
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/dropdown

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");

    }

    // 3. Select all the options from multiple select dropdown.

    @Test
            public void selectOptions(){

        Select dropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        List<WebElement> options = dropdown.getOptions();
        for (WebElement each : options) {
            each.click();

            // 4. Print out all selected values.

            System.out.println(each.getText() + " is selected: " + each.isSelected());

        }

        // 5. Deselect all values.
        dropdown.deselectAll();

    }
    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}

package com.cydeo.tests.day8_properties_config_reader.ExtraTasks.FindElements;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class T1_T2_T3_Links {

    @Test
    public void numberOfLinks(){

        //TC #1: Checking the number of links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com

        Driver.getDriver().get("https://www.openxcell.com");

        //3. Count the number of the links on the page and verify
        //Expected: 355

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));

        int size = links.size();
        System.out.println("size = " + size);
        Assert.assertTrue(size==355);

    }

    @Test
    public void textOfLinks(){

        //TC #2: Printing out the texts of the links on the page
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com

        Driver.getDriver().get("https://www.openxcell.com");

        //3. Print out all of the texts of the links on the page

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));

        for (WebElement each : links) {
            System.out.println("each.getText() = " + each.getText());
        }

    }

    @Test
    public void linksWithNoTest(){

        //TC #3: Counting the number of links that does not have text
        //1. Open Chrome browser
        //2. Go to https://www.openxcell.com

        Driver.getDriver().get("https://www.openxcell.com");

        //3. Count the number of links that does not have text and verify
        //Expected: 259

        List<WebElement> links = Driver.getDriver().findElements(By.tagName("a"));
        int countOfLinksWithNoText = 0;
        for (WebElement each : links) {
             if (each.getText().isEmpty()){
                 countOfLinksWithNoText++;
             }
        }
        System.out.println("countOfLinksWithNoText = " + countOfLinksWithNoText);

        Assert.assertTrue(countOfLinksWithNoText==259);


    }

}

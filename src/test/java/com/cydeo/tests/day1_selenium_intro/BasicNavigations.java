package com.cydeo.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        //1- Setting up the Web driver manager
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the Selenium WebDriver
        // This is the line opening an empty browser
        WebDriver driver = new ChromeDriver();

        // This line will maximize the browser size
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        //3- Go to "https://www.tesla.com"
        driver.get("https://www.tesla.com");

        // get the title of the page
        String titleOfPage = driver.getTitle();
        System.out.println("titleOfPage = " + titleOfPage);

        String currentURL = driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);


        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use Selenium to navigate back
        driver.navigate().back();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use Selenium to navigate forward
        driver.navigate().forward();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use Selenium to navigate refresh
        driver.navigate().refresh();

        // Stop code execution for 3 seconds
        Thread.sleep(3000);

        // Use navigate().to()
        driver.navigate().to("https://www.google.com");

        // get the current title of page after getting the Tesla page
        titleOfPage=driver.getTitle();

        // get the title of the page
        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("titleOfPage = " + titleOfPage);

        // get the current URL using Selenium

        currentURL=driver.getCurrentUrl();
        System.out.println("currentURL = " + currentURL);

        // This will close the currently opened window
        driver.close();

        // This will close all of the opened windows
        driver.quit();

    }

}

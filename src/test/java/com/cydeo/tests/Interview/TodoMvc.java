package com.cydeo.tests.Interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TodoMvc {

    //The web application under test http://todomvc.com/
    //1. The firsts step should be to load the website, click within the JavaScript tab,
    // and select the Polymer link
    //2. The second step should be: Add two Todo items
    //3. Bonus: (optional stretch goal): Edit the content of the second Todo item

    public WebDriver driver;

    @BeforeMethod
    public  void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void test(){
        //loading website
        driver.get("http://todomvc.com/");

        // click within the JavaScript tab
        WebElement javaScriptTab = driver.findElement(By.xpath("//div[.='JavaScript']"));
        javaScriptTab.click();

        //select the Polymer link
        WebElement polymerLink = driver.findElement(By.linkText("Polymer"));
        polymerLink.click();

        // Add two Todo items
        WebElement toDoBox = driver.findElement(By.xpath("//input[@id='new-todo']"));
        toDoBox.sendKeys("reading"+ Keys.ENTER, "playing"+Keys.ENTER);

        // Edit the content of the second Todo item
        WebElement secondToDo = driver.findElement(By.xpath("//label[.='playing']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(secondToDo).perform();

        WebElement edit = driver.findElement(By.id("edit"));
        edit.sendKeys(Keys.CONTROL+"a", Keys.DELETE);
        edit.sendKeys("swimming");


    }


}

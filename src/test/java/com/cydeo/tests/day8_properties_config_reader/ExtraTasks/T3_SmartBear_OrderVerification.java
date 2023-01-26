package com.cydeo.tests.day8_properties_config_reader.ExtraTasks;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_SmartBear_OrderVerification {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //TC#3: Smartbear software order verification
        //1. Open browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void orderVerification(){

        //1. login to Smartbear software

        SmartBearUtils.loginToSmartBear(driver);

        //2. Click on View all orders

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[.='View all orders']"));
        viewAllOrders.click();

        //3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement SusanMcLarenOrderDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));
        String expectedOrderDate = "01/05/2010";
        String actualOrderDate = SusanMcLarenOrderDate.getText();
        Assert.assertEquals(actualOrderDate,expectedOrderDate);

    }


}

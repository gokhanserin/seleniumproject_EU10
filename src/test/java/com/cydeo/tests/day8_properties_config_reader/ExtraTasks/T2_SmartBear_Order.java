package com.cydeo.tests.day8_properties_config_reader.ExtraTasks;

import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.CreditCardType;
import com.github.javafaker.DateAndTime;
import com.github.javafaker.Faker;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class T2_SmartBear_Order {

    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){

        //TC#2: Smartbear software order placing
        //1. Open browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void orderPlacing(){

        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        //3. Enter username: “Tester”
        //4. Enter password: “test”
        //5. Click on Login button

        SmartBearUtils.loginToSmartBear(driver);

        //6. Click on Order

        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();

        //7. Select familyAlbum from product, set quantity to 2

        Select productDropdown = new Select(driver.findElement(By.tagName("select")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.sendKeys("2");

        //8. Click to “Calculate” button

        WebElement calculate = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code

        WebElement inputName = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        Faker faker = new Faker();
        inputName.sendKeys(faker.name().name());

        WebElement inputStreet = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        inputStreet.sendKeys(faker.address().streetName());

        WebElement inputCity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        inputCity.sendKeys(faker.address().city());

        WebElement inputState = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        inputState.sendKeys(faker.address().state());

        WebElement inputZipcode = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        inputZipcode.sendKeys(faker.address().zipCode().replace("-",""));


        //10. Click on “visa” radio button

        WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();

        //11. Generate card number using JavaFaker

        WebElement cardNumber = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        cardNumber.sendKeys(faker.numerify("################"));

        // Fill expire date

        WebElement inputExpireDate = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        /*String month = String.valueOf(faker.number().numberBetween(01, 12));
        String year = String.valueOf(faker.number().numberBetween(22, 50));
        inputExpireDate.sendKeys(month+"/"+year);
*/
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");

        String dob = sdf.format(faker.date().birthday());
        inputExpireDate.sendKeys(dob);


        //12. Click on “Process”

        WebElement processButton = driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']"));
        processButton.click();

        //13. Verify success message “New order has been successfully added.”

        WebElement successMessage = driver.findElement(By.tagName("strong"));
        String actualSuccessText = successMessage.getText();
        String expectedSuccessText = "New order has been successfully added.";

        Assert.assertEquals(actualSuccessText,expectedSuccessText);


    }


}

package com.cydeo.tests.day8_properties_config_reader.ExtraTasks;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GasMileageCalculatorTest {

    @Test
    public void gas_mileage_calculator(){

        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net

        Driver.getDriver().get("https://www.calculator.net");

        //3. Search for “gas mileage” using search box

        WebElement searchBox = Driver.getDriver().findElement(By.id("calcSearchTerm"));
        searchBox.sendKeys("gas mileage");

        //4. Click on the “Gas Mileage Calculator” link

        WebElement gas_mileage_calculator_link = Driver.getDriver().findElement(By.linkText("Gas Mileage Calculator"));
        gas_mileage_calculator_link.click();

        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”

        String titleOfPage = Driver.getDriver().getTitle();
        Assert.assertTrue(titleOfPage.equals("Gas Mileage Calculator"));

        //b. “Gas Mileage Calculator” label is displayed

        //boolean h1 = Driver.getDriver().findElement(By.tagName("h1")).isDisplayed();
        //System.out.println("Gas Mileage Calculator label is displayed =" + h1);

        WebElement h1 = Driver.getDriver().findElement(By.tagName("h1"));
        String h1_label = h1.getText();
        Assert.assertTrue(h1_label.equals("Gas Mileage Calculator"));

        //6. Locate, clear and type “7925” into “Current odometer” field

        WebElement inputCurrentOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mucodreading']"));
        inputCurrentOdometer.clear();
        inputCurrentOdometer.sendKeys("7925");

        //7. Locate, clear and type “7550” into “Previous odometer” field

        WebElement inputPreviousOdometer = Driver.getDriver().findElement(By.xpath("//input[@id='mupodreading']"));
        inputPreviousOdometer.clear();
        inputPreviousOdometer.sendKeys("7550");

        //8. Locate, clear and type “16” into “Gas added” field

        WebElement inputGasAdded = Driver.getDriver().findElement(By.xpath("//input[@id='mugasputin']"));
        inputGasAdded.clear();
        inputGasAdded.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field

        WebElement inputGasPrice = Driver.getDriver().findElement(By.xpath("//input[@id='mugasprice']"));
        inputGasPrice.clear();
        inputGasPrice.sendKeys("3.55");

        //10. Click on Calculate button

        WebElement calculateButton = Driver.getDriver().findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        calculateButton.click();

        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”

        WebElement mpgValue = Driver.getDriver().findElement(By.xpath("//span[@class='bigtext']"));
        String mpg = mpgValue.getText();
        System.out.println("mpg = " + mpg);
        Assert.assertTrue(mpg.contains("23.44"));

    }

}

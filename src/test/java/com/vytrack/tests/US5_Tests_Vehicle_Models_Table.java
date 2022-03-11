package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import com.vytrack.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US5_Tests_Vehicle_Models_Table extends TestBase {

    @Test
    public void verify_columns_as_sales_manager() {
        //login as sales manager
        VytrackUtils.loginAsSalesManager();
        //go to Fleet tab
        String fleetTabElementLocator = "//span[normalize-space()='Fleet' and contains(@class, 'title title-level-1')]";

        WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath(fleetTabElementLocator));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
       // String vehiclesModelModuleLocator = "//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]";
        WebElement vehiclesModelElement = Driver.getDriver().findElement(By.xpath("//span[normalize-space()='Vehicles Model' and contains(@class, 'title title-level-2')]"));
        //we are using for waiting until loader mask disappearing
        VytrackUtils.waitTillLoaderMaskDisappear();
        vehiclesModelElement.click();
        VytrackUtils.waitTillLoaderMaskDisappear();
        List<String> actualheadersFromVehicleModelTable = WebTableUtils.getHeadersFromVehicleModelTable();
        List<String> expectedheadersFromVehicleModelTable=new ArrayList<>(Arrays.asList(
                "MODEL NAME",
                "MAKE",
                "CAN BE REQUESTED",
                "CVVI",
                "CO2 FEE (/MONTH)",
                "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)",
                "CO2 EMISSIONS",
                "FUEL TYPE",
                "VENDORS"
        ));

        //verify header columns
        Assert.assertEquals(actualheadersFromVehicleModelTable, expectedheadersFromVehicleModelTable);


    }

    @Test
    public void verify_columns_as_driver(){
        VytrackUtils.loginAsDriver();
        //go to Fleet
        WebElement fleetTab = Driver.getDriver().findElement(By.xpath("  //span[@class='title title-level-1']"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTab).perform();

        //go to vehicles model
        WebElement vehiclesModelTab = Driver.getDriver().findElement(By.xpath("//span[text()='Vehicles Model']"));
        vehiclesModelTab.click();

        //result==>You do not have permissions to perform this action
        String expectedResult = "You do not have permission to perform this action.";
        WebElement result = Driver.getDriver().findElement(By.xpath("//div[.='You do not have permission to perform this action.']"));
       String actualResult = result.getText();
        System.out.println("actualResult = " + actualResult);

         Assert.assertEquals(actualResult,expectedResult);
       // Assert.assertTrue(result.isDisplayed());


    }
}


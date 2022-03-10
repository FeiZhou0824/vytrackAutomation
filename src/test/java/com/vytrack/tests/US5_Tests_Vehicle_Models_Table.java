package com.vytrack.tests;

import com.vytrack.tests.base.TestBase;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class US5_Tests_Vehicle_Models_Table extends TestBase {

    @Test
    public void verify_columns_as_sales_manager(){

        //log in as sales manager
        VytrackUtils.loginAsSalesManager();

        // go to Fleet Tab

       WebElement fleetTabElement = Driver.getDriver().findElement(By.xpath("//div[@id='main-menu']/ul/li/a/span[contains(text(),'Fleet')]"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetTabElement).perform();
    }




}

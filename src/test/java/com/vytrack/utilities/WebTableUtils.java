package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class WebTableUtils {
    /**
     * this method is using for finding vehicle model table headers
     *
     * @return List<String> titles
     */

    public static List<String> getHeadersFromVehicleModelTable() {
        List<WebElement> headerElements = Driver.getDriver().findElements(By.xpath("//thead[@class='grid-header']//th//span[1]"));
        List<String> headerTitles = new ArrayList<>();
       // headerElements.forEach(each -> headerTitles.add(each.getText()));
        for (WebElement each : headerElements) {
            headerTitles.add(each.getText());
        }
        return headerTitles;
    }
}
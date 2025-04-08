package com.loginwebsite.BaseClass;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaits {

    private WebDriverWait wait;

    WebDriverWaits(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ReadConfigFile.getProperty("timeout"))));
    }

    public void waitForElementToAppear(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    
}

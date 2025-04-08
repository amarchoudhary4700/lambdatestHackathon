package com.loginwebsite.BaseClass;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class BaseUI extends WebDriverWaits{
    private WebDriver driver;
    
    protected BaseUI(WebDriver driver){
        super(driver);
        this.driver = driver;
        
    }

    public void logMessage(String msg){
        Reporter.log(msg, true);
    }

    public void launchUrl(String url){
        driver.get(url);
        logMessage("Launched url: "  + url); 
    }


}

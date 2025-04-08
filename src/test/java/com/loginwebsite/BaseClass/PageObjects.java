package com.loginwebsite.BaseClass;

import org.openqa.selenium.WebDriver;

import com.loginwebsite.PageAction.JSAlerts;
import com.loginwebsite.PageAction.LoginPage;

public class PageObjects {
    public LoginPage loginPage;
    public JSAlerts jsAlert;

    PageObjects(WebDriver driver){
        loginPage = new LoginPage(driver);
        jsAlert = new JSAlerts(driver);
    }
    
}

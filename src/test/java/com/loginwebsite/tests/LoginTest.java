package com.loginwebsite.tests;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.loginwebsite.BaseClass.Methods;
import com.loginwebsite.BaseClass.ReadDataFile;

public class LoginTest extends Methods {

     @DataProvider(name = "credentials")
    public Object[][] getLoginData() throws FileNotFoundException {
        return new Object[][] {
            {ReadDataFile.getProperty("username"), ReadDataFile.getProperty("password")},
            {"user2@example.com", "password2"}
        };
    }

    @Test(dataProvider = "credentials")
    public void test01_login(String user, String password) throws FileNotFoundException{
        baseUI.launchUrl(ReadDataFile.getProperty("URL1"));
        test.loginPage.enterUserName(user);
        test.loginPage.enterPasword(password);
        test.loginPage.clickLoginButton();

        boolean isUserLoggedIn = test.loginPage.checkUserLoggedIn();
        
        Assert.assertEquals(isUserLoggedIn, true, "Login failed.....");
    }


    @Test
    public void test02_jsAlerts() throws InterruptedException, FileNotFoundException{
        baseUI.launchUrl(ReadDataFile.getProperty("URL2"));
        test.jsAlert.clickForJSAlert();
        String handleJSAlert = test.jsAlert.handleClickForJSAlert();

        test.jsAlert.clickForJSConfirm();
        String handleJSConfirm = test.jsAlert.handleClickForJSConfirm();

        test.jsAlert.clickForJSPrompt();
        String handleJSPrompt = test.jsAlert.handleClickForJSPrompt();

        Assert.assertEquals(handleJSAlert, "You successfully clicked an alert", "JS Alert is not clicked...");
        Assert.assertEquals(handleJSConfirm, "You clicked: Ok", "JS Confirm is not clicked...");
        Assert.assertEquals(handleJSPrompt, "You entered:", "JS Prompt is not clicked...");


    }
    
}

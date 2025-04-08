package com.loginwebsite.PageAction;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.loginwebsite.BaseClass.BaseUI;

public class LoginPage extends BaseUI{
    protected WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    private WebElement userName;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//button[i[text()=\" Login\"]]")
    private WebElement loginBtn;

    @FindBy(id="#flash")
    private WebElement isUserLoggedIn;



    /*******************************************************************************************/

    public void enterUserName(String username){
        waitForElementToAppear(userName);
        userName.sendKeys(username);
        logMessage("Entered username: " + username);
    }
    

    public void enterPasword(String pass){
        waitForElementToAppear(password);
        password.sendKeys(pass);
        logMessage("Entered password: " + pass);
    }

    public void clickLoginButton(){
        waitForElementToAppear(loginBtn);
        loginBtn.click();
        logMessage("Clicked login button");
    }

    public boolean checkUserLoggedIn(){
        boolean flag = true;
        try{
            waitForElementToAppear(isUserLoggedIn);
        }catch(NoSuchElementException ex){
            flag = false;
        }catch(TimeoutException ex){
            flag = false;
        }
        return flag;
    }
}

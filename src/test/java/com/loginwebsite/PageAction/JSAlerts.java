package com.loginwebsite.PageAction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.loginwebsite.BaseClass.BaseUI;

public class JSAlerts extends BaseUI{
    protected WebDriver driver;

    public JSAlerts(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//button[text()='Click for JS Alert']")
    private WebElement clickJSAlert;

    @FindBy(xpath="//button[text()='Click for JS Confirm']")
    private WebElement clickJSConfirm;

    @FindBy(xpath="//button[text()='Click for JS Prompt']")
    private WebElement clickJSPrompt;

    @FindBy(id="result")
    private WebElement result;


    public void clickForJSAlert(){
        waitForElementToAppear(clickJSAlert);
        clickJSAlert.click();
        logMessage("Clicked for JS alert");
    }

    public String handleClickForJSAlert() throws InterruptedException{
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(3));
        return result.getText();
    }

    public void clickForJSConfirm(){
        waitForElementToAppear(clickJSConfirm);
        clickJSConfirm.click();
        logMessage("Clicked for JS confirm");
    }

    public String handleClickForJSConfirm() throws InterruptedException{
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(3));
        return result.getText();
    }

    public void clickForJSPrompt(){
        waitForElementToAppear(clickJSPrompt);
        clickJSPrompt.click();
        logMessage("Clicked for JS prompt");
    }

    public String handleClickForJSPrompt() throws InterruptedException{
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        Thread.sleep(Duration.ofSeconds(3));
        return result.getText();
    }
}

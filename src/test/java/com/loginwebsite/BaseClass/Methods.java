package com.loginwebsite.BaseClass;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Methods {
    public WebDriver driver;
    public BaseUI baseUI;
    public PageObjects test;


    public WebDriver browserDriver(){
         switch (ReadConfigFile.getProperty("browser")){
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;
         
            default:
                break;
         }
         return driver;
    }

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException{
        switch(ReadConfigFile.getProperty("server")){
            case "lambdatest":
            driver = remoteLambdatestDriver();
            break;

            case "local":
            driver = browserDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ReadConfigFile.getProperty("timeout"))));
        baseUI = new BaseUI(driver);
        test = new PageObjects(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    private RemoteWebDriver remoteLambdatestDriver() throws MalformedURLException, URISyntaxException{
         RemoteWebDriver driver;

         ChromeOptions browserOptions = new ChromeOptions();
         browserOptions.setPlatformName("Windows 10");
         browserOptions.setBrowserVersion("134");
         HashMap<String, Object> ltOptions = new HashMap<String, Object>();
         ltOptions.put("username", "amarchoudhary4700");
         ltOptions.put("accessKey", "LT_oZkgUUdy5Ou7FvEV7GuM3591ezxc88haVZIbFLxLFZJJMiT");
         ltOptions.put("project", "Untitled");
         ltOptions.put("selenium_version", "4.0.0");
         ltOptions.put("w3c", true);
         browserOptions.setCapability("LT:Options", ltOptions);
        
        driver = new RemoteWebDriver(new URI("https://hub.lambdatest.com/wd/hub").toURL(), browserOptions);
        return driver;
    }
    
}

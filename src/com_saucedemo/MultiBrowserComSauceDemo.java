package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserComSauceDemo {

    static String browser = "fireFOX"; // create browser variable
    static WebDriver driver; //create driver variable
    //create baseUrl variable
    static String baseUrl = "https://www.saucedemo.com/";

    public static void main(String[] args) {


        if (browser.equalsIgnoreCase("chrome")) {
            //Setting up key and copy value from drivers file.
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            // Creating an object for chromedriver
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FireFox")) {
            //Setting up key and copy value from drivers file.
            System.setProperty("webdriver.firefox.driver", "drivers/geckodriver.exe");
            // Creating an object for firefoxriver
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            //Setting up key and copy value from drivers file.
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            // Creating an object for edgedriver
            driver = new EdgeDriver();
        } else {
            //else body if wrong name entered
            System.out.println("Wrong Browser name");
        }

        //launching the url.
        driver.get(baseUrl);
        //Maximize window size
        driver.manage().window().maximize();
        //implicit time given to driver for 20 seconds.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Getting and printing a title of the page.
        String title = driver.getTitle();
        System.out.println("Page title is : " + title);

        //Printing current Url
        System.out.println("Current URL : " + driver.getCurrentUrl());

        //printing page source
        System.out.println("Page Source code : " + driver.getPageSource());
        //finding and email field element
        WebElement emailField = driver.findElement(By.name("user-name"));
        // sending a data to email field element
        emailField.sendKeys("performance_glitch_user");

        // finding password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // Sending a data to password field element
        passwordField.sendKeys("secret_sauce");

        //closing the window.
        driver.quit();
    }
}

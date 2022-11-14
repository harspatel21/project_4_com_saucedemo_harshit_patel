package com_saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FireFoxComSauceDemo {
    public static void main(String[] args) {
        //create baseUrl variable
        String baseUrl = "https://www.saucedemo.com/";
        //Setting up key and copy value from drivers file.
        System.setProperty("webdriver.firefox.driver", "drivers/geckodriver.exe");
        // Creating an object for firefoxdriver
        WebDriver driver = new FirefoxDriver();
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
        emailField.sendKeys("problem_user");

        // finding password field element
        WebElement passwordField = driver.findElement(By.name("password"));
        // Sending a data to password field element
        passwordField.sendKeys("secret_sauce");

        //closing the window.
        driver.quit();
    }
}

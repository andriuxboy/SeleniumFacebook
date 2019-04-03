/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mayab.calidad.selenium;

import static java.util.function.Predicate.isEqual;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author andriuxboy
 */

public class TestFacebookLogin {
    
    private static final String URL = "https://www.facebook.com";
    private static WebDriver driver;
    
    
    public TestFacebookLogin() {
    }
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/andriuxboy/Documents/code/selenium/chromedriver");
        driver = new ChromeDriver();
    }
    
    @After
    public void tearDown() {
        driver.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
        @Test
        public void JavaLoginSuccess() throws InterruptedException {
        driver.get(URL);
        String name = "";
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        username.sendKeys("andriuxboy@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        pass.sendKeys("Kirby123");
        pass.submit();
        Thread.sleep(5000);
        Boolean isPresent;
        isPresent = driver.findElements(By.xpath("//*[@id=\"u_0_a\"]/div[1]/div[1]/div/a/span/span")).size() > 0;
        if(isPresent)
            name = driver.findElement(By.xpath("//*[@id=\"navItem_100035355638787\"]/a/div")).getText();
        assertThat("Raul Gonzalez",is(equalTo(name)));
        }
        @Test
        public void JavaLoginFail() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        username.sendKeys("kirby545@outlook.com");
        WebElement pass = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        pass.sendKeys("234523462346");
        pass.submit();
        Thread.sleep(9000);
        boolean isPresent;
        isPresent = driver.findElements(By.xpath("//*[@id=\"globalContainer\"]/div[3]/div/div/div")).size() > 0;
        assertThat(true,is(equalTo(isPresent)));
        }
        
        
        
}

package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrangeHRMTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-save-password-bubble");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Wait until the OrangeHRM login page is loaded
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("username")
                )
        );

        System.out.println("OrangeHRM login page is ready.");
        System.out.println("Please enter Username and Password manually.");
    }


    @Test
    public void validLoginTest() {

        System.out.println("VALID LOGIN TEST");
        System.out.println("Enter valid username and password manually.");
        System.out.println("Then click Login.");


        // Wait until Dashboard appears after YOUR manual login
        wait.until(
                ExpectedConditions.urlContains("/dashboard")
        );


        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL: " + currentUrl);


        assertTrue(
                currentUrl.contains("/dashboard"),
                "Dashboard was not displayed after valid login"
        );


        System.out.println("VALID LOGIN TEST PASSED");


        // Keep browser open for 5 seconds
        sleep(5000);
    }


    @Test
    public void invalidLoginTest() {

        System.out.println("INVALID LOGIN TEST");
        System.out.println("Enter username and WRONG password manually.");
        System.out.println("Then click Login.");


        // Wait until the Invalid credentials message appears
        var errorMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//p[contains(@class,'oxd-alert-content-text')]"
                        )
                )
        );


        String message = errorMessage.getText();

        System.out.println("Error message: " + message);


        assertTrue(
                message.contains("Invalid credentials"),
                "Expected 'Invalid credentials' but received: " + message
        );


        System.out.println("INVALID LOGIN TEST PASSED");


        // Keep browser open for 5 seconds
        sleep(5000);
    }


    @AfterEach
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }


    private void sleep(long milliseconds) {

        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}
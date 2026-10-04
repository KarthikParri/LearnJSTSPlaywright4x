package com.example.salesforce;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        try {
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
                options.addArguments("--headless=new");
            }
            options.addArguments("--window-size=1440,1000");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ZERO);
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
            loginPage = new LoginPage(driver);
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to initialize the Chrome WebDriver", exception);
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void openLoginPage() {
        if (loginPage == null) {
            throw new IllegalStateException("Login page is not initialized");
        }
        loginPage.open();
    }

    @Test(priority = 1)
    public void rememberMeCanBeSelected() {
        loginPage.setRememberMe(true);
        Assert.assertTrue(loginPage.isRememberMeSelected(), "Remember-me should be selected");
    }

    @Test(priority = 2)
    public void validCredentialsShouldLeaveLoginPage() {
        String username = configuredValue("salesforce.username", "SALESFORCE_USERNAME");
        String password = configuredValue("salesforce.password", "SALESFORCE_PASSWORD");
        if (username == null || password == null) {
            throw new SkipException("Provide Salesforce test credentials to run the valid-login test");
        }

        loginPage.login(username, password);
        Assert.assertTrue(loginPage.waitForLoginOutcome(), "Salesforce did not return a login outcome");
        Assert.assertFalse(loginPage.isOnLoginPage(), "Valid credentials should leave the Salesforce login page");
    }

    @Test(dataProvider = "invalidCredentials", priority = 3)
    public void invalidCredentialsShouldDisplayAnError(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.isLoginErrorDisplayed(), "Invalid credentials should display a login error");
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][] {
                { "invalid.user@example.invalid", "IncorrectPassword123!" },
                { "another.invalid.user@example.invalid", "WrongPassword456!" }
        };
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException exception) {
                throw new IllegalStateException("Unable to close the Chrome WebDriver", exception);
            }
        }
    }

    private String configuredValue(String propertyName, String environmentName) {
        String value = System.getProperty(propertyName);
        if (value == null || value.isBlank()) {
            value = System.getenv(environmentName);
        }
        return value == null || value.isBlank() ? null : value;
    }
}

package com.example.salesforce;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private static final String LOGIN_URL = "https://login.salesforce.com/?locale=in";
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(15);

    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//input[@id='rememberUn']")
    private WebElement rememberMe;

    @FindBy(xpath = "//*[@id='error']")
    private WebElement loginError;

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = Objects.requireNonNull(driver, "WebDriver must not be null");
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        try {
            driver.get(LOGIN_URL);
            wait.until(ExpectedConditions.visibilityOf(username));
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to open the Salesforce login page", exception);
        }
    }

    public void login(String user, String pass) {
        try {
            wait.until(ExpectedConditions.visibilityOf(username)).clear();
            username.sendKeys(Objects.requireNonNull(user, "Username must not be null"));
            wait.until(ExpectedConditions.visibilityOf(password)).clear();
            password.sendKeys(Objects.requireNonNull(pass, "Password must not be null"));
            wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to submit Salesforce login credentials", exception);
        }
    }

    public void setRememberMe(boolean selected) {
        try {
            WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(rememberMe));
            if (checkbox.isSelected() != selected) {
                checkbox.click();
            }
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to update the remember-me setting", exception);
        }
    }

    public boolean isRememberMeSelected() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(rememberMe)).isSelected();
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to read the remember-me setting", exception);
        }
    }

    public boolean waitForLoginOutcome() {
        try {
            return wait.until(currentDriver -> {
                if (!currentDriver.getCurrentUrl().contains("login.salesforce.com")) {
                    return true;
                }
                try {
                    return loginError.isDisplayed();
                } catch (NoSuchElementException exception) {
                    return false;
                }
            });
        } catch (TimeoutException exception) {
            return false;
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to determine the Salesforce login outcome", exception);
        }
    }

    public boolean isLoginErrorDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(loginError)).isDisplayed();
        } catch (TimeoutException exception) {
            return false;
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to inspect the Salesforce login error", exception);
        }
    }

    public boolean isOnLoginPage() {
        try {
            return driver.getCurrentUrl().contains("login.salesforce.com");
        } catch (WebDriverException exception) {
            throw new IllegalStateException("Unable to read the current browser URL", exception);
        }
    }
}

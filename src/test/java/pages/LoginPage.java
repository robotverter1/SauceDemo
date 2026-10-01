package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com";
    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
    }

    public void enterAuthData(){
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
        driver.findElement(usernameField).sendKeys(getLoginUsernameFromPage());
        driver.findElement(passwordField).sendKeys(getPasswordFromPage());
        driver.findElement(loginButton).click();
    }

    private String getLoginUsernameFromPage(){
        return driver.findElement(By.cssSelector("#login_credentials br:nth-of-type(1)")).getText();
    }

    private String getPasswordFromPage(){
        String origPasswordString = driver.findElement(By.cssSelector("[data-test='login-password']")).getText();
        return origPasswordString.replace("Password for all users:", "").trim();
    }

    public boolean isAuthCompleted(){
        return driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
    }
}

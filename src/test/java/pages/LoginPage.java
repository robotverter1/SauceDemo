package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com";
    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.cssSelector("[data-test='password']");
    private static final By loginButton = By.cssSelector("[data-test='login-button']");
    private static final By nextPageTitle = By.cssSelector("[data-test='title']");

    public By getLoginButton(){
        return loginButton;
    }

    public By getNextPageTitle(){
        return nextPageTitle;
    }

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
    }

    public void enterAuthData(){
        driver.findElement(usernameField).sendKeys("standard_user");
        driver.findElement(passwordField).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
    }

    public void enterAuthData(String username){
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(username);
        driver.findElement(loginButton).click();
    }

    private String getLoginUsernameFromPage(){ //Работает
        String rawText = driver.findElement(By.id("login_credentials")).getText();
        String[] standardUsername = rawText.split("\n"); //Здесь спаршенный текст собирается и разделяется по разным строкам внутри массива, т.к. selenium считает, что <br> - это перенос строки
        return (String) standardUsername[1].trim(); //Этот метод выбирает из списка br-ов вторую спаршенную строку и выдаёт её
    }

//    private String getPasswordFromPage(){
//        String origPasswordString = driver.findElement(By.cssSelector("[data-test='login-password']")).getText();
//        return origPasswordString.replace("Password for all users:", "").trim();
//    }

    public boolean isAuthCompleted(){
        return driver.findElement(By.cssSelector("[data-test='title']")).isDisplayed();
    }

    public boolean isAuthFailed(){
        return driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed();
    }
}

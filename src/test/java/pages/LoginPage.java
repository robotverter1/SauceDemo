package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com/";
    private static final By usernameField = By.id("user-name");
    private static final By passwordField = By.id("password");
    private static final By loginButton = By.id("login-button");

    public void open(){
        driver.get(URL);
    }

    public void enterAuthData(){
        wait.until(ExpectedConditions.titleIs("Swag Labs"));

    }

    private String getLoginUsernameFromPage(){
        driver.findElement(By.id("login_credentials")); //Допилить строку, чтобы забирался один из <br>-ов
        return null;
    }
}

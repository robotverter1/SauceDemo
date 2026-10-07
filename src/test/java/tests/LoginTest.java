package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BasicTest{

    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        loginPage = new LoginPage(driver);
    }

    @Test
    public void completingAuth(){
        loginPage.open(); //Fix string by refactoring code inside the class constructor or open method
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
        loginPage.enterAuthData();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getNextPageTitle()));
        Assert.assertTrue(loginPage.isAuthCompleted(), "Auth completely done");
    }

     @Test
     public void uncompletedAuth(){
        loginPage.open();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.getLoginButton()));
        loginPage.enterAuthData("standart_user");
        loginPage.isAuthFailed();
        Assert.assertTrue(loginPage.isAuthFailed(), "Auth uncompleted");
     }

}

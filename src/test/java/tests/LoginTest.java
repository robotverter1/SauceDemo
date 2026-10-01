package tests;

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
        loginPage.enterAuthData();
        Assert.assertTrue(loginPage.isAuthCompleted(), "Auth completely done");
    }

    @Test
    public void uncompletedAuth(){
        loginPage.open();//Fix string by refactoring code inside the class constructor or open method
        // Complete test
    }

}

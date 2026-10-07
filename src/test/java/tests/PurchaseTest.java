package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BackpackPurchasePage;
import pages.LoginPage;

public class PurchaseTest extends BasicTest{

    protected BackpackPurchasePage purchasePage;
    protected LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        purchasePage = new BackpackPurchasePage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testingPurchase(){
        loginPage.open();
        loginPage.enterAuthData();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(purchasePage.getAddToCartBtn()));
        purchasePage.purchase();
        purchasePage.enterDataInForm();
        Assert.assertTrue(purchasePage.confirmPurchase(), "Purchase done");
    }

}

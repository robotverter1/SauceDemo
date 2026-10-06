package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BackpackPurchasePage;

public class PurchaseTest extends BasicTest{

    protected BackpackPurchasePage purchasePage;

    @BeforeMethod
    public void setUp(){
        purchasePage = new BackpackPurchasePage(driver);
    }

    @Test
    public void testingPurchase(){ //Fix test
        purchasePage.open();
        purchasePage.purchase();
        purchasePage.enterDataInForm();
        Assert.assertTrue(purchasePage.confirmPurchase(), "Purchase done");
    }

}

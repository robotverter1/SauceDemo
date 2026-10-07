package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackpackPurchasePage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com/inventory.html";
    private static final By addToCartBtn = By.cssSelector("[data-test='add-to-cart-sauce-labs-backpack']");
    private static final By cartBtn = By.cssSelector("[data-test='shopping-cart-link']");
    private static final By checkoutBtn = By.cssSelector("[data-test='checkout']");


    public By getAddToCartBtn(){
        return addToCartBtn;
    }
    public BackpackPurchasePage(WebDriver driver){
        super(driver);
    }

    public void open(){
        driver.get(URL);
    }

//    public void addToCart(){
//        driver.findElement(addToCartBtn).click();
//    }
//
//    public void goToCart(){
//        driver.findElement(cartBtn);
//    }
//
//    public void checkoutBtnToForm(){
//        driver.findElement(By.id("checkout"));
//    }
    public void purchase(){
        driver.findElement(addToCartBtn).click();
        driver.findElement(cartBtn).click();
        driver.findElement(checkoutBtn).click();
    }

    public void enterDataInForm(){
        driver.findElement(By.cssSelector("[data-test='firstName']")).sendKeys("avc");
        driver.findElement(By.cssSelector("[data-test='lastName']")).sendKeys("avc");
        driver.findElement(By.cssSelector("[data-test='postalCode']")).sendKeys("123456");
        driver.findElement(By.cssSelector("[data-test='continue']")).click();
    }

    public boolean confirmPurchase(){
        driver.findElement(By.cssSelector("[data-test='finish']")).click();
        return driver.findElement(By.cssSelector("[data-test='complete-header']")).isDisplayed();
    }

}

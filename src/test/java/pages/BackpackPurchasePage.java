package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BackpackPurchasePage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com/inventory.html";
    private static final By addToCartBtn = By.className("btn btn_primary btn_small btn_inventory ");
    private static final By cartBtn = By.className("shopping_cart_link");

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
        driver.findElement(cartBtn);
        driver.findElement(By.id("checkout"));
    }

    public void enterDataInForm(){
        driver.findElement(By.id("first-name")).sendKeys("avc");
        driver.findElement(By.id("last-name")).sendKeys("avc");
        driver.findElement(By.id("postal-code")).sendKeys("123456");
        driver.findElement(By.id("continue")).click();
    }

    public boolean confirmPurchase(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("summary_info_label")));
        driver.findElement(By.id("finish")).click();
        return driver.findElement(By.className("complete-header")).isDisplayed();
    }

}

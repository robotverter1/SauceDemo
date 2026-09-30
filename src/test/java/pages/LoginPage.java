package pages;

import org.testng.annotations.BeforeMethod;

public class LoginPage extends BasicPage{

    private static final String URL = "https://www.saucedemo.com/";

    public void open(){
        driver.get(URL);
    }

}

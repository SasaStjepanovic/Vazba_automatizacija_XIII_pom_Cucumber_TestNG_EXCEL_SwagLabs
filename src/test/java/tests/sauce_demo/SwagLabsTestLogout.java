package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SwagLabsInventoryPage;
import pages.SwagLabsLoginPage;
import pages.components.HeaderComponent;

public class SwagLabsTestLogout extends BaseTest{

    @BeforeMethod
    public void setup(String browser, String env) throws Exception {
        init(browser);
        openApp(env);
        new SwagLabsLoginPage(driver).login("standard_user","secret_sauce", "PRODUCTS", "positive");
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test(enabled = true)
    public void swagLabsLogoutValid() throws InterruptedException {
        String[] menuItems = {"ALL ITEMS", "ABOUT", "LOGOUT", "RESET APP STATE"};
        SwagLabsInventoryPage slip =new SwagLabsInventoryPage(driver);
        slip.headerComponent.clickMenu();
        slip.checkItems(menuItems);
        slip.headerComponent.logout("positive", "Login");
    }

}
package tests.sauce_demo;

import excel.ExcelSupport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.sauce_demo.components.HeaderComponent;
import pages.sauce_demo.*;
import pages.sauce_demo.components.HeaderComponent;

import java.util.Map;

public class SwagLabsTestEndToEnd extends BaseTest {

    Map<String, String> data;

    @BeforeMethod
    @Parameters({"browser", "env", "fileName", "sheetName", "rowNum"})
    public void setup(String browser, String env, String fileName, String sheetName, String rowNum) throws Exception {
        init(browser);
        openApp(env);
        data = new ExcelSupport().getExcelRow(fileName, sheetName, rowNum);
        new SwagLabsLoginPage(driver).login( data.get("username"),data.get("password"), data.get("testType"), data.get("expectedText"));
    }
    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test(enabled = true)
    public void buyProduct() throws InterruptedException {
        String[] menuItems = {"ALL ITEMS", "ABOUT", "LOGOUT", "RESET APP STATE"};
        SwagLabsInventoryPage ip = new SwagLabsInventoryPage(driver);

        ip.clickAddProductByIndex(1, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(2, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(3, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(4, "ADD TO CART", "REMOVE");
        ip.clickAddProductByName("Sauce Labs Onesie", "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(6, "ADD TO CART", "REMOVE");

        HeaderComponent hp = new HeaderComponent(driver);

        hp.checkHeaderShopingCart("6", "No");
        ip.clickShoppingCart("Your Cart");

        hp.checkHeaderShopingCart("6", "No");
        new SwagLabsCartPage(driver).clickCheckout("Checkout: Your Information");

        hp.checkHeaderShopingCart("6", "No");
        new SwagLabsCheckoutPage(driver).checkout("Test","Test", "11212", "Checkout: Overview");

        hp.checkHeaderShopingCart("6", "No");
        new SwagLabsCheckoutOverviewPage(driver).clickFinish("Checkout: Complete!");
        hp.checkHeaderShopingCart("", "Yes");

        new SwagLabsCheckoutCompletePage(driver).clickBackToProducts("Products");
        hp.checkHeaderShopingCart("", "Yes");

        hp.clickMenu();
        hp.logout(data.get("testTypeLogout"),data.get("logoutMessage"));
    }
    //add assertions
}
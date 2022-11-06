package tests.sauce_demo;

import excel.ExcelSupport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.sauce_demo.*;
import tests.BaseTest;

import java.util.Map;

public class SwagLabsTests extends BaseTest {

    Map<String, String> data;

    @BeforeMethod
    public void setup() throws Exception {
        init();
        openSauceDemoApp("QA");
        data = new ExcelSupport().getExcelRow("","","");
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test(enabled = false)
    public void swagLabsLogin(){
        new SwagLabsLoginPage(driver).login("standard_user","secret_sauce");
    }

    @Test(enabled = false)
    public void swagLabsGoToCart(){
        new SwagLabsLoginPage(driver).login("standard_user","secret_sauce");
        new SwagLabsInventoryPage(driver).clickShoppingCart();
    }

    @Test
    public void buyProduct(){
        new SwagLabsLoginPage(driver).login("standard_user","secret_sauce");
        SwagLabsInventoryPage ip = new SwagLabsInventoryPage(driver);

        ip.clickAddProductByName("Sauce Labs Onesie");
        ip.clickAddProductByIndex(4);

        ip.clickShoppingCart();

        new SwagLabsCartPage(driver).clickCheckout();

        new SwagLabsCheckoutPage(driver).checkout("Test","Test", "11212");

        new SwagLabsCheckoutOverviewPage(driver).clickFinish();

        new SwagLabsCheckoutCompletePage(driver).clickBackToProducts();
    }

    //add assertions
}
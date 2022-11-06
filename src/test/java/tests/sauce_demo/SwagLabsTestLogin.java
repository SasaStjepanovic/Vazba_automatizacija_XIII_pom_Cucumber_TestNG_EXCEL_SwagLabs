package tests.sauce_demo;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.sauce_demo.BasePage;
import pages.sauce_demo.SwagLabsLoginPage;

import java.io.IOException;

public class SwagLabsTestLogin extends BaseTest {

    @BeforeMethod
    public void setup(String browser, String env) throws Exception {
        init(browser);
        openApp(env);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        new BasePage(driver).reportScreenshot("Prvi_Screenshot", "Ovo je moj prvi description ikada", "yes");
        quit();
    }

    @Test(enabled = true, priority = 1)
    public void swagLabsLoginValid() throws InterruptedException {
        new SwagLabsLoginPage(driver).login("standard_user","secret_sauce", "PRODUCTS", "positive");
    }

    @Test(enabled = true, priority = 2)
    public void swagLabsLoginInvalid() throws InterruptedException {
        new SwagLabsLoginPage(driver).login("locked_out_user","secret_sauce", "Epic sadface: Sorry, this user has been locked out.", "negative");
    }



}
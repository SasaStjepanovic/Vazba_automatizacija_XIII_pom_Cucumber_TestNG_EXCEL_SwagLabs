package steps.sauce_demo;

import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import pages.sauce_demo.*;
import pages.sauce_demo.components.FooterComponent;
import tests.sauce_demo.BaseTest;
import pages.sauce_demo.components.HeaderComponent;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {
    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String ScrShootName = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrShootName");
    String ScrShootDesc = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrShootDesc");
    String ScrYesOrNo = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrYesOrNo");
    @Before
    public void setup() throws Exception {
        init(browser);
        openApp(env);
//        new BasePage(driver).reportScreenshot(ScrShootName, ScrShootDesc, ScrYesOrNo);
    }

    @After
    public void tearDown() {
        quit();
    }


    @Given("I am logged in")
    public void iAmLoggedInANDAND() throws InterruptedException {
        new SwagLabsLoginPage(driver).login( data.get("username"),data.get("password"), data.get("testType"), data.get("expectedText") );
    }

    @Given("I am logged out")
    public void iAmLoggedOut() throws InterruptedException {
        SwagLabsInventoryPage slip =new SwagLabsInventoryPage(driver);
        slip.headerComponent.logout( data.get("testTypeLogout"), data.get("logoutMessage"));
    }

    @And("I by products")
    public void iByProducts() throws InterruptedException {
        SwagLabsInventoryPage ip = new SwagLabsInventoryPage(driver);

        ip.clickAddProductByIndex(1, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(2, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(3, "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(4, "ADD TO CART", "REMOVE");
        ip.clickAddProductByName("Sauce Labs Onesie", "ADD TO CART", "REMOVE");
        ip.clickAddProductByIndex(6, "ADD TO CART", "REMOVE");
    }

    @And("I checked menu items")
    public void iCheckedMenuItems() throws InterruptedException {
        String[] menuItems = {"ALL ITEMS", "ABOUT", "LOGOUT", "RESET APP STATE"};
        SwagLabsInventoryPage slip =new SwagLabsInventoryPage(driver);
        slip.checkItems(menuItems);
    }

    @And("I checkedout")
    public void iCheckedout() {
        SwagLabsInventoryPage ip = new SwagLabsInventoryPage(driver);
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
    }

    @And("I clicked menu button")
    public void iClickedMenuButton() {
        BasePage bp = new BasePage(driver);

        SwagLabsInventoryPage slip =new SwagLabsInventoryPage(driver);

        slip.headerComponent.clickMenu();
        slip.clickAllButton("ALL ITEMS");
    }

    @Given("I read test data from {string} {string} {string}")
    public void iReadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
        data = new ExcelSupport().getExcelRow(fileName,sheetName, rowNum);
    }

    //    @When("I enter username")
//    public void iEnterUsername() {
//        new SwagLabsLoginPage(driver).enterUsername("standard_user");
//    }
//
//    @When("I enter username {string}")
//    public void iEnterUsername(String username) {
//        new SwagLabsLoginPage(driver).enterUsername(username);
//    }
//
//    @And("I enter password")
//    public void iEnterPassword() {
//        new SwagLabsLoginPage(driver).enterPassword("secret_sauce");
//    }
//
//    @And("I click login button")
//    public void iClickLoginButton() {
//        new SwagLabsLoginPage(driver).clickLoginButton();
//    }
//
//    @Then("I should be logged in")
//    public void iShouldBeLoggedIn() {
//        //todo assertion
//    }

//    @And("I click product")
//    public void iClickProduct() {
//        new SwagLabsInventoryPage(driver).clickAddProductByIndex(1, "ADD TO CART", "REMOVE" );
//    }
//
//    @Then("I should see an error message {string}")
//    public void iShouldSeeAnErrorMessage(String message) {
//        //asertacija
//    }

//    @And("I enter password {string}")
//    public void iEnterPassword(String password) {
//        new SwagLabsLoginPage(driver).enterPassword(password);
//    }
//
//    @And("choose test type {string}")
//    public void chooseTestType(String arg0) {
//
//    }
//
//    @Then("I should get text {string}")
//    public void iShouldGetText(String arg0) {
//    }
}
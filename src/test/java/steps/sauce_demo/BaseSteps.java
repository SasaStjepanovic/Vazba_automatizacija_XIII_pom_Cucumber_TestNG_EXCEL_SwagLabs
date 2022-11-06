package steps.sauce_demo;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.sauce_demo.SwagLabsInventoryPage;
import pages.sauce_demo.SwagLabsLoginPage;
import tests.BaseTest;

public class BaseSteps extends BaseTest {

    @Before
    public void setup() throws Exception {
        init();
        openSauceDemoApp("QA");
    }

    @After
    public void tearDown() {
        quit();
    }

    @When("I enter username")
    public void iEnterUsername() {
        new SwagLabsLoginPage(driver).enterUsername("standard_user");
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        new SwagLabsLoginPage(driver).enterUsername(username);
    }

    @And("I enter password")
    public void iEnterPassword() {
        new SwagLabsLoginPage(driver).enterPassword("secret_sauce");
    }

    @And("I click login button")
    public void iClickLoginButton() {
        new SwagLabsLoginPage(driver).clickLoginButton();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        //todo assertion
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        iEnterUsername();
        iEnterPassword();
        iClickLoginButton();
    }

    @And("I click product")
    public void iClickProduct() {
        new SwagLabsInventoryPage(driver).clickAddProductByIndex(1);
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String message) {
        //asertacija
    }
}
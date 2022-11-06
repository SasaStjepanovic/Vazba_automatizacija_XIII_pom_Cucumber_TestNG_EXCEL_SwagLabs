package pages.sauce_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.BasePage;

public class SwagLabsLoginPage extends BasePage {

    public SwagLabsLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#user-name")
    WebElement username;
    @FindBy(css = "#password")
    WebElement password;
    @FindBy(css = "#login-button")
    WebElement loginButton;

    public void enterUsername(String value){
        typeText(username,value,"Username input field");
    }

    public void enterPassword(String value){
        typeText(password,value,"Password input field");
    }

    public void clickLoginButton(){
        clickElement(loginButton, "Login button");
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyInvalidCredentialsErrorMessage(String message){

    }

}
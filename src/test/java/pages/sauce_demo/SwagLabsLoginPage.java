package pages.sauce_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//div[@class='header_secondary_container']//span[@class='title']")
    WebElement titleAfterLoginPass;

    @FindBy(xpath = "//form//h3")
    WebElement titleAfterLoginFail;

    //div[@class="header_secondary_container"]
    public void enterUsername(String value){
        typeText(username,value,"Username input field");
    }

    public void enterPassword(String value){
        typeText(password,value,"Password input field");
    }

    public void clickLoginButton(){
        clickElement(loginButton, "Login button");
    }


    public void login(String username, String password, String testType, String expectedText) throws InterruptedException {
        enterUsername(username);
        enterPassword(password);
        Thread.sleep(2000);
        clickLoginButton();

        if(testType.equalsIgnoreCase("positive")){
            compareText(titleAfterLoginPass,expectedText);
        } else {
            compareText(titleAfterLoginFail,expectedText);
        }

    }

}
package pages.sauce_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.booking.components.FooterComponent;
import pages.booking.components.HeaderComponent;

public class SwagLabsCheckoutPage extends BasePage {

    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public SwagLabsCheckoutPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#first-name")
    WebElement firstName;

    @FindBy(css = "#last-name")
    WebElement lastName;

    @FindBy(css = "#postal-code")
    WebElement zip;

    @FindBy(css = "#continue")
    WebElement continueBtn;

    public void enterFirstName(String value){
        typeText(firstName, value, "First name");
    }

    public void enterLastName(String value){
        typeText(lastName, value, "Last name");
    }

    public void enterZip(String value){
        typeText(zip, value, "ZIP");
    }

    public void clickContinue(){
        clickElement(continueBtn, "Continue button");
    }

    public void checkout(String firstNameTxt, String lastNameTxt, String zipTxt){
        enterFirstName(firstNameTxt);
        enterLastName(lastNameTxt);
        enterZip(zipTxt);
        clickContinue();
    }

}
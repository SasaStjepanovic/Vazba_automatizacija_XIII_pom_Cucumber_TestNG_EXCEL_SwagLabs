package pages.sauce_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.booking.components.FooterComponent;
import pages.booking.components.HeaderComponent;

public class SwagLabsCartPage extends BasePage {

    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public SwagLabsCartPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#checkout")
    WebElement checkout;

    public void clickCheckout() {
        clickElement(checkout, "Checkout button");
    }

}
package pages.sauce_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.sauce_demo.components.FooterComponent;
import pages.sauce_demo.components.HeaderComponent;

public class SwagLabsCheckoutOverviewPage extends BasePage {

    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public SwagLabsCheckoutOverviewPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#finish")
    WebElement finish;

    @FindBy(xpath = "//div[@class='header_secondary_container']//span[@class='title']")
    WebElement titleAfterLogin;

    public void clickFinish(String expectedText){
        clickElement(finish, "Finish button");
        scroll("0", "0");
        compareText(titleAfterLogin,expectedText.toUpperCase());
    }

}
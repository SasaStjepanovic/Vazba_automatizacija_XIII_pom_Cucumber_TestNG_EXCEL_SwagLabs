package pages.sauce_demo.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

public class HeaderComponent extends BasePage {

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#react-burger-menu-btn")
    WebElement menu;

    public void clickMenu(){
        clickElement(menu,"Menu button");
    }

}

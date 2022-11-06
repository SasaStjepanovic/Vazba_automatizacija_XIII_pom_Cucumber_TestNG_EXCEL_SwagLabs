package pages.sauce_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;
import pages.booking.components.FooterComponent;
import pages.booking.components.HeaderComponent;

public class SwagLabsInventoryPage extends BasePage {

    HeaderComponent headerComponent;
    FooterComponent footerComponent;

    public SwagLabsInventoryPage(WebDriver driver) {
        super(driver);
        headerComponent = new HeaderComponent(driver);
        footerComponent = new FooterComponent(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".shopping_cart_link")
    WebElement shoppingCart;

    public void clickShoppingCart(){
        clickElement(shoppingCart, "Shopping cart icon");
    }

    public void clickAddProductByName(String name){
        clickElement(
                driver.findElement(By.xpath("//*[text()='"+name+"']/../../..//div[@class='pricebar']//button")),
                "Add product "+name);
    }

    public void clickAddProductByIndex(int i){
        clickElement(
                driver.findElement(By.xpath("//div[@class='inventory_list']/div["+i+"]//button")),
                "Add product "+i);
    }

}
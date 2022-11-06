package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;
    int waitTime = 30;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickElement(WebElement element, String log){
        WebDriverWait webDriverWait = new WebDriverWait(driver,waitTime);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            System.out.println("Clicked element: " + log);
        }catch (Exception e){
            e.printStackTrace();
            element.click();
            System.out.println("Clicked element: " + log);
        }
    }

    public void clickElement(WebElement element){
        WebDriverWait webDriverWait = new WebDriverWait(driver,waitTime);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
        }catch (Exception e){
            e.printStackTrace();
            element.click();
        }
    }

    public void typeText(WebElement element, String text, String log){
        WebDriverWait webDriverWait = new WebDriverWait(driver,waitTime);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered text: "+text+" to element: " + log);
        }catch (Exception e){
            e.printStackTrace();
            element.sendKeys(text);
            System.out.println("Entered text: "+text+" to element: " + log);
        }
    }

    public void checkCheckbox(WebElement element, String yesOrNo, String log){
        WebDriverWait webDriverWait = new WebDriverWait(driver,waitTime);

        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            if(yesOrNo.equalsIgnoreCase("Yes")){
                if(!element.isSelected()){
                    element.click();
                }
            } else {
                if(element.isSelected()){
                    element.click();
                }
            }
            System.out.println("Checked element" + log);
        }catch (Exception e){
            e.printStackTrace();
            if(yesOrNo.equalsIgnoreCase("Yes")){
                if(!element.isSelected()){
                    element.click();
                }
            } else {
                if(element.isSelected()){
                    element.click();
                }
            }
            System.out.println("Checked element" + log);
        }
    }

    //select

    //get text

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",element);
    }

}
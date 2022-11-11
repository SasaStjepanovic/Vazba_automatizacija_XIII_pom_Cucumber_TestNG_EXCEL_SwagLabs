package pages.sauce_demo;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class BasePage {

    public WebDriver driver;
    int waitTime = 45;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void explicitWait(WebElement element) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, waitTime);
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void clickElement(WebElement element, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            System.out.println("Clicked element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            element.click();
            System.out.println("Clicked element: " + log);
        }
    }

    public void typeText(WebElement element, String text, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            element.click();
            element.clear();
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " to element: " + log);
        } catch (Exception e) {
            e.printStackTrace();
            element.sendKeys(text);
            System.out.println("Entered text: " + text + " to element: " + log);
        }
    }

    public void checkCheckbox(WebElement element, String yesOrNo, String log) {
        explicitWait(element);

        try {
            scrollToElement(element);
            new Actions(driver).moveToElement(element).perform();
            if (yesOrNo.equalsIgnoreCase("Yes")) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    System.out.println("element je vec kliknut");
//                    element.click();
                }
            }
            System.out.println("Checked element" + log);
        } catch (Exception e) {
            e.printStackTrace();
            if (yesOrNo.equalsIgnoreCase("Yes")) {
                if (!element.isSelected()) {
                    element.click();
                }
            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
            System.out.println("Checked element" + log);
        }
    }

    //select

    //get text
    public void compareText(WebElement element, String expectedText) {
            String actualTitle = element.getText();
            Assert.assertEquals(actualTitle, expectedText);
            System.out.println("Actual title is: " + actualTitle);
        }

    public void scrollToElement (WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", element);
    }

    public void scroll(String x,String y){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("window.scrollBy("+x+","+y+")");
    }

    // Ovaj scrshot metod je odvojen i koristi
    public void takeScreenshotWithTimeStamps(String name, String yesNo) throws IOException {
        if(yesNo.equalsIgnoreCase("YES")) {
            long finish = System.currentTimeMillis();
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/results/screenshots/" +name+"_"+finish+".png"));
        }
    }

    public void takeScreenshot(String name, String yesNo) throws IOException {
        if(yesNo.equalsIgnoreCase("YES")) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("src/results/screenshots/"+name+".png"));
        }
    }

    public void reportScreenshotAllure(String name, String desc, String yesOrNo) throws IOException {
        if(yesOrNo.equalsIgnoreCase("YES")) {
            long finish = System.currentTimeMillis();
            takeScreenshot(name+ "_" +finish, yesOrNo);
            Path path = Paths.get("src/results/screenshots/"+name+"_"+finish+".png");
            InputStream is = Files.newInputStream(path);
            Allure.addAttachment(desc,is);
        }
    }

    public String randomEmail() {
        String email;
        Random random = new Random();
        int randomEmail = random.nextInt(5000);
        email = "stjepanovic" + randomEmail + "@yahoo.com";
        return email;
    }


    public String randomUser() {
        Faker fakerData = new Faker();
        String name = String.valueOf(fakerData.name());
        System.out.println(name);
        return name;
    }


}

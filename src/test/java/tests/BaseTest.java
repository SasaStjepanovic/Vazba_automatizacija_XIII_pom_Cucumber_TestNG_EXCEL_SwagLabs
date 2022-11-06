package tests;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import selenium.DriverManager;
import selenium.DriverManagerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    DriverManager driverManager;

    String screenshot = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("screenshot");

    public void init() throws Exception {
        driverManager = DriverManagerFactory.getDriverManager("CHROME");
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void init(String browser, String wait) throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(browser);
        driver = driverManager.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(wait), TimeUnit.SECONDS);
    }

    public void openSauceDemoApp(String env) {
        switch (env.toUpperCase()){
            case "QA" :{
                driver.get("https://www.saucedemo.com/");
            }
            break;
            // dodati jos neki case
            // dodati default blok
        }
    }

    public void openBookingApp(String env) {
        switch (env.toUpperCase()){
            case "QA" :{
                driver.get("https://www.booking.com/index.sr.html");
            }
            break;
            // dodati jos neki case
            // dodati default blok
        }
    }

    public void quit(){
        driverManager.quitWebDriver();
    }

    public void takeScreenshot(String name, String yesNo) throws IOException {
        if (screenshot.equalsIgnoreCase("Yes")) {
            if (yesNo.equalsIgnoreCase("YES")) {
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File("src/results/screenshots/" + name + ".png"));
            }
        }
    }

    public void reportScreenshot(String name, String desc, String yesOrNo) throws IOException {
        if(screenshot.equalsIgnoreCase("Yes")) {
            if (yesOrNo.equalsIgnoreCase("Yes")) {
                takeScreenshot(name, yesOrNo);
                Path path = Paths.get("src/results/screenshots/" + name + ".png");
                InputStream is = Files.newInputStream(path);
                Allure.addAttachment(desc, is);
            }
        }
    }

}
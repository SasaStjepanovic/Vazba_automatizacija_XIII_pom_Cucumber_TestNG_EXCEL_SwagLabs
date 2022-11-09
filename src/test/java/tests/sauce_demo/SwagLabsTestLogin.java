package tests.sauce_demo;

import excel.ExcelSupport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.sauce_demo.BasePage;
import pages.sauce_demo.SwagLabsLoginPage;

import java.io.IOException;
import java.util.Map;

public class SwagLabsTestLogin extends BaseTest {

    Map<String, String> data;

    @BeforeMethod
    @Parameters({"browser", "env", "ScrShootName", "ScrShootDesc", "ScrYesOrNo"})
    public void setup(String browser, String env,String ScrShootName,String ScrShootDesc,String ScrYesOrNo) throws Exception {
        init(browser);
        openApp(env);
        new BasePage(driver).reportScreenshot(ScrShootName, ScrShootDesc, ScrYesOrNo);
    }

    @AfterMethod
    public void tearDown() throws IOException {
        quit();
    }

    @Test(enabled = true, priority = 1)
    @Parameters({"fileName", "sheetName", "rowNum"})
    public void swagLabsLoginValid(String fileName, String sheetName, String rowNum) throws InterruptedException, IOException {
        data = new ExcelSupport().getExcelRow(fileName, sheetName, rowNum);
        new SwagLabsLoginPage(driver).login( data.get("username"),data.get("password"), data.get("testType"), data.get("expectedText"));

    }

}
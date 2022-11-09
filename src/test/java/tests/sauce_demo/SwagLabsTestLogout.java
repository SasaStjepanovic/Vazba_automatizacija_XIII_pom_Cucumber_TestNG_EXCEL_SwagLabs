package tests.sauce_demo;

import excel.ExcelSupport;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.sauce_demo.SwagLabsInventoryPage;
import pages.sauce_demo.SwagLabsLoginPage;
import pages.sauce_demo.SwagLabsInventoryPage;
import pages.sauce_demo.SwagLabsLoginPage;

import java.io.IOException;
import java.util.Map;

public class SwagLabsTestLogout extends BaseTest {

    Map<String, String> data;

    @BeforeMethod
    @Parameters({"browser", "env", "fileName", "sheetName", "rowNum"})
    public void setup(String browser, String env, String fileName, String sheetName, String rowNum) throws Exception {
        init(browser);
        openApp(env);
        data = new ExcelSupport().getExcelRow(fileName, sheetName, rowNum);
        new SwagLabsLoginPage(driver).login( data.get("username"),data.get("password"), data.get("testType"), data.get("expectedText"));
    }

    @AfterMethod
    public void tearDown(){
        quit();
    }

    @Test(enabled = true)
    @Parameters({"fileName", "sheetName", "rowNum"})
    public void swagLabsLogoutValid() throws InterruptedException, IOException {

        String[] menuItems = {"ALL ITEMS", "ABOUT", "LOGOUT", "RESET APP STATE"};
        SwagLabsInventoryPage slip =new SwagLabsInventoryPage(driver);
        slip.headerComponent.clickMenu();
        slip.headerComponent.clickAllButton("ALL ITEMS");
        slip.checkItems(menuItems);
        slip.headerComponent.logout(data.get("testTypeLogout"),data.get("logoutMessage"));
    }

}
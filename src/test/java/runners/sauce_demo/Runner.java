package runners.sauce_demo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
        features = "src/test/java/features/sauce_demo",
        glue = "steps/sauce_demo",
        tags = "@Run",
        plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
package runners;

import helpers.container.ContainerSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import helpers.factory.DriverFactory;

@CucumberOptions(
        features = "src/test/resources/scenarios",
        glue = {"steps", "hooks"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "rerun:target/rerun.txt"
        },
        monochrome = true,
        dryRun = false,
        tags = "@smoke"
)
public class Runner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void initContainer() {
        ContainerSetup.setup();
        DriverFactory.getDriver();
    }

    @AfterSuite
    public void tearDownSuite() {
        DriverFactory.quitDriver();
    }

    @Override
    @org.testng.annotations.DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

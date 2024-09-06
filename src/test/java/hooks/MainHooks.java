package hooks;

import helpers.container.ContainerSetup;
import helpers.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MainHooks {

    private DriverFactory driverFactory;

    @Before
    public void setUp() {
        driverFactory = ContainerSetup.getComponent(DriverFactory.class);
        driverFactory.getDriver();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        driverFactory.quitDriver();
    }
}

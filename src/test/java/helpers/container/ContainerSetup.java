package helpers.container;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import helpers.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import pages.webpages.LoginPage;

public class ContainerSetup {

    private static MutablePicoContainer container;

    public static void setup() {
        if (container == null) {
            container = new DefaultPicoContainer();
            container.addComponent(DriverFactory.class);
            container.addComponent(WebDriver.class, container.getComponent(DriverFactory.class).getDriver());
            container.addComponent(LoginPage.class);
        }
    }

    public static <T> T getComponent(Class<T> type) {
        if (container == null) {
            throw new IllegalStateException("Container has not been initialized. Call setup() first.");
        }
        return container.getComponent(type);
    }
}

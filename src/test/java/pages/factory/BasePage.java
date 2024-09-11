package pages.factory;

import helpers.container.Context;
import helpers.logger.LoggerFactory;
import helpers.readers.ConfigurationReader;
import helpers.utils.BrowserUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;

public abstract class BasePage extends BrowserUtils {

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    protected String baseUrl;

    public BasePage(Context context) {
        super(context);
        this.baseUrl = ConfigurationReader.get("baseUrl");
    }

    public void navigateTo(String path, WebElement element) {
        String fullUrl = baseUrl + path;
        logger.info("Navigating to url: " + fullUrl);
        driver.get(fullUrl);
        waitForVisibilityOfElement(element);
    }

}

package pages.factory;

import helpers.container.Context;
import helpers.readers.ConfigurationReader;
import helpers.utils.BrowserUtils;
import org.openqa.selenium.WebElement;

public abstract class BasePage extends BrowserUtils {

    protected String baseUrl;

    public BasePage(Context context) {
        super(context);
        this.baseUrl = ConfigurationReader.get("baseUrl");
    }

    public void navigateTo(String path, WebElement element) {
        String fullUrl = baseUrl + path;
        driver.get(fullUrl);
        waitForVisibilityOfElement(element);
    }

}

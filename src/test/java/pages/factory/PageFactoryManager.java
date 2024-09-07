package pages.factory;

import helpers.container.Context;
import org.openqa.selenium.WebDriver;
import pages.webpages.LoginPage;

public class PageFactoryManager {
    private static LoginPage loginPage;
    private static Utils utils;

    public static LoginPage getLoginPage(Context context) {
        return loginPage == null ? new LoginPage(context) : loginPage;
    }

    public static Utils getUtils(Context context) {
        return utils == null ? new Utils(context) : utils;
    }
}

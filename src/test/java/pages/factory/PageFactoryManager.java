package pages.factory;

import helpers.container.Context;
import pages.webpages.DashboardPage;
import pages.webpages.LoginPage;

public class PageFactoryManager {
    private static Utils utils;
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;


    public static LoginPage getLoginPage(Context context) {
        return loginPage == null ? new LoginPage(context) : loginPage;
    }

    public static Utils getUtils(Context context) {
        return utils == null ? new Utils(context) : utils;
    }

    public static DashboardPage getDashboardPage(Context context) {
        return dashboardPage == null ? new DashboardPage(context) : dashboardPage;
    }
}

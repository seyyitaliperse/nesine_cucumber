package pages.factory;

import helpers.container.Context;
import pages.webpages.DashboardPage;
import pages.webpages.LoginPage;
import pages.webpages.KisiselBilgilerim;
import pages.webpages.PromosyonlarimPage;

public class PageFactoryManager {
    private static Utils utils;
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static PromosyonlarimPage promosyonlarimPage;
    private static KisiselBilgilerim kisiselBilgilerim;


    public static LoginPage getLoginPage(Context context) {
        return loginPage == null ? new LoginPage(context) : loginPage;
    }

    public static Utils getUtils(Context context) {
        return utils == null ? new Utils(context) : utils;
    }

    public static DashboardPage getDashboardPage(Context context) {
        return dashboardPage == null ? new DashboardPage(context) : dashboardPage;
    }

    public static PromosyonlarimPage getPromosyonlarimPage(Context context) {
        return promosyonlarimPage == null ? new PromosyonlarimPage(context) : promosyonlarimPage;
    }

    public static KisiselBilgilerim getKisiselBilgilerim(Context context) {
        return kisiselBilgilerim == null ? new KisiselBilgilerim(context) : kisiselBilgilerim;
    }
}

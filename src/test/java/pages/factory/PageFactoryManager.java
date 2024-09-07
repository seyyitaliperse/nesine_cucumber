package pages.factory;

import helpers.container.Context;
import pages.webpages.DashboardPage;
import pages.webpages.LoginPage;
import pages.webpages.PersonalInformation;
import pages.webpages.PromotionsPage;

public class PageFactoryManager {
    private static Utils utils;
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static PromotionsPage promotionsPage;
    private static PersonalInformation personalInformation;


    public static LoginPage getLoginPage(Context context) {
        return loginPage == null ? new LoginPage(context) : loginPage;
    }

    public static Utils getUtils(Context context) {
        return utils == null ? new Utils(context) : utils;
    }

    public static DashboardPage getDashboardPage(Context context) {
        return dashboardPage == null ? new DashboardPage(context) : dashboardPage;
    }

    public static PromotionsPage getPromotionsPage(Context context) {
        return promotionsPage == null ? new PromotionsPage(context) : promotionsPage;
    }

    public static PersonalInformation getPersonalInformation(Context context) {
        return personalInformation == null ? new PersonalInformation(context) : personalInformation;
    }
}

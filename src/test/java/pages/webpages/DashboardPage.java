package pages.webpages;

import helpers.container.Context;
import helpers.logger.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class DashboardPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DashboardPage.class);

    public DashboardPage(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    //Header elements
    @FindBy(xpath = "//span[@data-testid='header-userid']")
    public WebElement uyeNoValue;

    //Hesabim Elements
    @FindBy(xpath = "//a[@data-testid='header-hesabim-btn']")
    private WebElement hesabimMenu;
    @FindBy(xpath = "//a[@data-testid='header-hesabim-cikis']")
    private WebElement cikisButton;
    @FindBy(xpath = "//a[@data-testid='header-hesabim-promosyonlarim']")
    private WebElement promosyonlarimButton;
    @FindBy(xpath = "//a[@data-testid='header-hesabim-bilgilerim']")
    private WebElement bilgilerimButton;

    public void openHesabimMenu() {
        try {
            logger.info("Opening hesabim menu by hovering over..");
            hoverOver(hesabimMenu);
        } catch (Exception e) {
            logger.error("Failed to open Hesabim menu: " + e.getMessage());
            throw new RuntimeException("Error occurred while opening Hesabim menu", e);
        }
    }

    public void logout() {
        try {
            logger.info("Logging out from app..");
            openHesabimMenu();
            click(cikisButton);
        } catch (Exception e) {
            logger.error("Failed to log out: " + e.getMessage());
            throw new RuntimeException("Error occurred while logging out", e);
        }
    }

    public void goToPromosyonlarim() {
        try {
            logger.info("Going to promoslarim page..");
            openHesabimMenu();
            click(promosyonlarimButton);
        } catch (Exception e) {
            logger.error("Failed to navigate to Promosyonlarim page: " + e.getMessage());
            throw new RuntimeException("Error occurred while navigating to Promosyonlarim page", e);
        }
    }

    public void goToBilgilerim() {
        try {
            logger.info("Going to bilgilerim page..");
            openHesabimMenu();
            click(bilgilerimButton);
        } catch (Exception e) {
            logger.error("Failed to navigate to Bilgilerim page: " + e.getMessage());
            throw new RuntimeException("Error occurred while navigating to Bilgilerim page", e);
        }
    }
}

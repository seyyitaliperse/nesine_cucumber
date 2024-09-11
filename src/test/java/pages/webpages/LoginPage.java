package pages.webpages;

import helpers.container.Context;
import helpers.logger.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class LoginPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    public LoginPage(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    //Evidence
    @FindBy(xpath = "//span[@data-testid='header-bakiye']")
    public WebElement balanceEvidence;


    //Inputs
    @FindBy(xpath = "//input[@data-test-id='header-username-input']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@data-test-id='header-password-input']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@data-test-id='header-login-btn']")
    private WebElement loginButton;

    //Dialog
    @FindBy(xpath = "//div[@class='modalContainer']//p")
    public WebElement invalidCredentialsDialogDetails;

    public void navigateToLoginPage() {
        try {
            navigateTo("", userNameInput);
        } catch (Exception e) {
            logger.error("Failed to navigate to Login Page: " + e.getMessage());
            throw new RuntimeException("Error occurred while navigating to Login Page", e);
        }
    }

    public void login(String userName, String password) {
        try {
            logger.info("Logging in nesine application..");
            enterText(userNameInput, userName);
            enterText(passwordInput, password);
            click(loginButton);
            waitForVisibilityOfElement(balanceEvidence);
        } catch (Exception e) {
            logger.error("Failed to log in: " + e.getMessage());
            throw new RuntimeException("Error occurred while logging in", e);
        }
    }

    public void loginNegative(String userName, String password) {
        try {
            logger.info("Trying to login application..");
            enterText(userNameInput, userName);
            enterText(passwordInput, password);
            click(loginButton);
        } catch (Exception e) {
            logger.error("Failed to log in (negative test): " + e.getMessage());
            throw new RuntimeException("Error occurred during negative login test", e);
        }
    }
}
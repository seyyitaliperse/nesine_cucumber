package pages.webpages;

import helpers.container.Context;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class LoginPage extends BasePage {

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
        navigateTo("", userNameInput);
    }

    public void login(String userName, String password){
        enterText(userNameInput, userName);
        enterText(passwordInput, password);
        click(loginButton);
        waitForVisibilityOfElement(balanceEvidence);
    }

    public void loginNegative(String userName, String password){
        enterText(userNameInput, userName);
        enterText(passwordInput, password);
        click(loginButton);
    }









}
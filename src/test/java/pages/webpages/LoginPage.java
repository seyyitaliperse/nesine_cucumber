package pages.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.FactoryPage;

public class LoginPage extends FactoryPage {

    //Evidence
    @FindBy(xpath = "//span[@data-testid='header-bakiye']")
    private WebElement balanceEvidence;


    //Inputs
    @FindBy(xpath = "//input[@data-test-id='header-username-input']")
    private WebElement userNameInput;
    @FindBy(xpath = "//input[@data-test-id='header-password-input']")
    private WebElement passwordInput;
    @FindBy(xpath = "//input[@data-test-id='header-login-btn']")
    private WebElement loginButton;

    //Dialog
    @FindBy(xpath = "//div[@class='modalContainer']//p")
    private WebElement invalidCredentialsDialogDetails;

    public void navigateToLoginPage() {
        navigateTo("", userNameInput);
    }

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password){
        enterText(userNameInput, userName);
        enterText(passwordInput, password);
        click(loginButton);
        waitForVisibilityOfElement(balanceEvidence);
    }









}
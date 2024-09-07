package pages.webpages;

import helpers.container.Context;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class DashboardPage extends BasePage {

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




    public void openHesabimMenu(){
        hoverOver(hesabimMenu);
    }

    public void logout(){
        openHesabimMenu();
        click(cikisButton);
    }

    public void goToPromosyonlarim(){
        openHesabimMenu();
        click(promosyonlarimButton);
    }

    public void goToBilgilerim(){
        openHesabimMenu();
        click(bilgilerimButton);
    }





}

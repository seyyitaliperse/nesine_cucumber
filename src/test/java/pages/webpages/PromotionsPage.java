package pages.webpages;

import helpers.container.Context;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class PromotionsPage extends BasePage {
    public PromotionsPage(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    @FindBy(id = "code")
    public WebElement promosyonKodunuzInput;

    @FindBy(id = "securityCode")
    private WebElement guvenlikKodunuzInput;

    public void fillKodGirisiComponents(String promotionCode, String securityCode){
        enterText(promosyonKodunuzInput, promotionCode);
        enterText(guvenlikKodunuzInput, securityCode);
    }



}

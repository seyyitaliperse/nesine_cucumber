package pages.webpages;

import helpers.container.Context;
import helpers.logger.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class PromosyonlarimPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(PromosyonlarimPage.class);

    public PromosyonlarimPage(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    @FindBy(id = "code")
    public WebElement promosyonKodunuzInput;

    @FindBy(id = "securityCode")
    private WebElement guvenlikKodunuzInput;

    public void fillKodGirisiComponents(String promotionCode, String securityCode) {
        try {
            logger.info("Filling kod girisi component...");
            enterText(promosyonKodunuzInput, promotionCode);
            enterText(guvenlikKodunuzInput, securityCode);
            logger.info("Kod girisi completed with promotion code: " + promotionCode + " and security code: " + securityCode);
        } catch (Exception e) {
            logger.error("Failed to fill Kod Girisi Components: " + e.getMessage());
            throw new RuntimeException("Error occurred while filling Kod Girisi Components", e);
        }
    }
}

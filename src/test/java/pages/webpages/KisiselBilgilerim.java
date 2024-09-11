package pages.webpages;

import helpers.container.Context;
import helpers.logger.LoggerFactory;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class KisiselBilgilerim extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(KisiselBilgilerim.class);

    public KisiselBilgilerim(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Üye Numarası']/following::span[1]")
    public WebElement uyeNumarasiValue;

}

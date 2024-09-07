package pages.webpages;

import helpers.container.Context;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.factory.BasePage;

public class PersonalInformation extends BasePage {
    public PersonalInformation(Context context) {
        super(context);
        PageFactory.initElements(context.getDriver(), this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Üye Numarası']/following::span[1]")
    public WebElement uyeNumarasiValue;



}

package helpers.factory;

import helpers.readers.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.get("browser");

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                    chromeHeadlessOptions.addArguments("--headless", "--disable-gpu", "--no-sandbox");
                    driver = new ChromeDriver(chromeHeadlessOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Driver'ı null yapıyoruz ki yeniden başlatılabilsin
        }
    }
}

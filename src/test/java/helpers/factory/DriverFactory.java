package helpers.factory;

import helpers.readers.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverFactory {

    private static WebDriver driver;
    private static WebDriverWait webDriverWait;
    private static long waitTime = Long.parseLong(ConfigurationReader.get("waitMillis"));
    private static String browser = ConfigurationReader.get("browser");

    public static WebDriver getDriver() {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    ChromeOptions chromeHeadlessOptions = new ChromeOptions();
                    chromeHeadlessOptions.addArguments("--headless", "--disable-gpu", "--no-sandbox");
                    driver = new ChromeDriver(chromeHeadlessOptions);
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriverWait getWebDriverWait(){
        return webDriverWait = new WebDriverWait(driver, Duration.ofMillis(waitTime));
    }
}

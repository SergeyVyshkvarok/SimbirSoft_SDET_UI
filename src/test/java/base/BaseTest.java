package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    private WebDriverWait wait2;
    private WebDriverWait wait5;
    private WebDriver driver;
    private static final String BASE_URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager";

    @BeforeMethod(description = "Browser startUp")
    protected void beforeMethod() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*", /*"--headless",*/ "--window-size=1920,1080");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        getDriver().get(BASE_URL);
    }

    @AfterMethod (description = "Browser tearDown")
    protected void afterMethod() {
        driver.quit();
    }
    protected WebDriver getDriver() {
        return driver;
    }
    protected WebDriverWait getWait2() {
        if (wait2 == null) {
            wait2 = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        }
        return wait2;
    }
    protected WebDriverWait getWait5() {
        if (wait5 == null) {
            wait5 = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        }
        return wait5;
    }
}

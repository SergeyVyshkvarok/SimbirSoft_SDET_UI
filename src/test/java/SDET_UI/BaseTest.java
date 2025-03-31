package SDET_UI;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

public class BaseTest extends BasePage {
    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToBasePage(), "Ошибка перехода на тестируемую страницу");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            closeBrowser();
        }
    }

    public static char numberToLetter(int num) {
        num = num % 26; // Обрабатываем числа > 25
        return (char) ('a' + num);
    }

}

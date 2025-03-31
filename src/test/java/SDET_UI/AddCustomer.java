package SDET_UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

public class AddCustomer extends BaseTest{

    @Test
    public void AddCustomer() throws InterruptedException {
        WebElement addCustomerButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[@ng-click='addCust()']")));
        addCustomerButton.click();
    }

    int[] arrayForPostCodeField = new int[10];

    @Test
    public void PostCodeFieldFilling() {
        Random random = new Random();

        String postCodeValue = "";

        for (int i = 0; i < 10; i++) {
            arrayForPostCodeField[i] = random.nextInt(0, 10);
            postCodeValue+= arrayForPostCodeField[i];
        }

        WebElement postCodeField = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//input[@placeholder='Post Code']")));
        postCodeField.clear();
        postCodeField.sendKeys(postCodeValue);
    }

    @Test
    public void firstNameFieldFilling() {
        WebElement postCodeFieldContent = driver.findElement(By.xpath("//input[@placeholder='Post Code']"));
        String realPostCodeContent = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].value", postCodeFieldContent);

        int[] arrayForFirstNameField = new int[5];
        for (int i = 0; i < 5; i++) {
            arrayForFirstNameField[i] = Integer.parseInt(realPostCodeContent.substring(i * 2, i * 2 + 2));
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arrayForFirstNameField) {
            char letter = numberToLetter(num);
            sb.append(letter);
        }
        WebElement firstNameField = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstNameField.sendKeys(sb.toString());
    }


}

package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;

public class AddCustomerNew extends BaseTest {

    @Test
    public void addCustomerTest() {

        String actualAlertText = new MainPage(getDriver())
                .goOnAddCustomerPage()
                .fillPostCode()
                .firstNameFieldFilling()
                .lastNameFieldFilling()
                .buttonAddCustomersClickToSubmit()
                .checkAlertString();

        Asssert.assertTrue(actualAlertText.contains("Customer added successfully with customer id:"));
    }
}

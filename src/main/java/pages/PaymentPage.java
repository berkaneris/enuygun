package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "div[data-testid='payment-type-credit_card-text']")
    private WebElement paymentPageText;

    @FindBy(css = "input[data-testid='cardNumber']")
    private WebElement cardNumberField;

    @FindBy(css = "input[data-testid='CVV']")
    private WebElement cvvField;

    @FindBy(css = "div[data-testid='cardMonth']")
    private WebElement expiryMonthDropDownMenu;

    @FindBy(css = "div[data-testid='cardYear']")
    private WebElement expiryYearDropDownMenu;

    @FindBy(css = "button[data-testid='payment-form-submit-button']")
    private WebElement payButton;

    @FindBy(css = "div[data-testid='cardNumber-error-message']")
    private WebElement errorMessageText;


    public void verifyPaymentPage(String str) {
        wait.until(ExpectedConditions.visibilityOf(payButton));
        BrowserUtils.scrollToElement(payButton);
        payButton.getText();
        Assertions.assertEquals(str, payButton.getText());

    }

    public void fillCardNumberField(String cardNumber) {
        cardNumberField.clear();
        cardNumberField.click();
        cardNumberField.sendKeys(cardNumber);
    }

    public void selectCardExpiryDate(String expiryDate) {

        String[] expiryDateParts = expiryDate.split(" ");
        String month = expiryDateParts[0];
        String year = expiryDateParts[1];






        Select selectMonth = new Select(expiryMonthDropDownMenu);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(expiryYearDropDownMenu);
        selectYear.selectByVisibleText(year);

    }

    public void fillCvvNumber(String cvvNumber) {
        cvvField.clear();
        cvvField.click();
        cvvField.sendKeys(cvvNumber);

    }

    public void clickOnPayButton() {
        payButton.click();
    }

    public void verifyCardNumberIsInvalid() {
        wait.until(ExpectedConditions.visibilityOf(errorMessageText));

        String expectedErrorMessage = "Lütfen geçerli bir kart numarası giriniz";
        String actualErrorMessage = errorMessageText.getText();

        Assertions.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message is different than the expected ");


    }
}

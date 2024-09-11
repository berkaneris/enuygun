package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.List;

public class PaymentPage extends BasePage {

    @FindBy(xpath = "div[data-testid='payment-type-credit_card-text']")
    private WebElement paymentPageText;

    @FindBy(css = "input[data-testid='cardNumber']")
    private WebElement cardNumberField;

    @FindBy(css = "input[data-testid='CVV']")
    private WebElement cvvField;

    @FindBy(css = "input[data-testid='cardMonth-input']")
    private WebElement expiryMonthDropDownMenu;

    @FindBy(css = "input[data-testid='cardYear-input']")
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
        try {

            WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(20));
            WebElement cardNumberField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[data-testid='cardNumber']")));

            cardNumberField.clear();
            cardNumberField.sendKeys(cardNumber);

        } catch (org.openqa.selenium.StaleElementReferenceException e) {

            System.out.println("StaleElementReferenceException caught. Retrying...");
            fillCardNumberField(cardNumber);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public void selectCardExpiryDate(String expiryDate) {

        String[] expiryDateParts = expiryDate.split(" ");
        String month = expiryDateParts[0];
        String year = expiryDateParts[1];


        expiryMonthDropDownMenu.click();

        List<WebElement> allMonths = DRIVER.findElements(By.xpath("//button[@class='sc-JfKsv eYmLW']"));

        for (int i = 0; i <= allMonths.size() - 1; i++) {

            if (allMonths.get(i).getText().contains(month)) {

                allMonths.get(i).click();

                break;

            }
        }

        expiryYearDropDownMenu.click();

        List<WebElement> allYears = DRIVER.findElements(By.xpath("//button[@class='sc-JfKsv eYmLW']"));

        for (int i = 0; i <= allYears.size() - 1; i++) {

            if (allYears.get(i).getText().contains(year)) {

                allYears.get(i).click();

                break;
            }
        }


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

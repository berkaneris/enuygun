package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;

import java.util.List;

public class PassengerInformationPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(), 'İletişim Bilgileri')]")
    private WebElement informationPageText;

    @FindBy(css = "input[id='contact_email']")
    private WebElement emailPaymentBox;

    @FindBy(css = "input[id='contact_cellphone']")
    private WebElement phoneNumberBox;

    @FindBy(css = "input[id='firstName_0']")
    private WebElement firstNameField;

    @FindBy(css = "input[id='lastName_0']")
    private WebElement lastNameField;

    @FindBy(css = "select[id='birthDateDay_0']")
    private WebElement dropDownMenuDay;

    @FindBy(css = "select[id='birthDateMonth_0']")
    private WebElement dropDownMenuMonth;

    @FindBy(css = "select[id='birthDateYear_0']")
    private WebElement dropDownMenuYear;

    @FindBy(css = "input[id='_0']")
    private WebElement idField;

    @FindBy(css = "label[class='form-check-label custom-control custom-radio']")
    private List<WebElement> genderList;

    @FindBy(xpath = "//button[@id='continue-button']")
    private WebElement continueToPaymentButton;


    public void verifyPassengerInformationPage(String str) {

        wait.until(ExpectedConditions.visibilityOf(informationPageText));
        Assertions.assertEquals(str, informationPageText.getText());
    }

    public void fillPaymentEmailBoxAndNumber(String str1, String str2) {
        emailPaymentBox.clear();
        emailPaymentBox.click();
        emailPaymentBox.sendKeys(str1);
        phoneNumberBox.clear();
        phoneNumberBox.click();
        phoneNumberBox.sendKeys(str2);
    }

    public void fillFirstNameAndLastNameFields(String firstName, String lastName) {
        firstNameField.click();
        firstNameField.sendKeys(firstName);
        lastNameField.click();
        lastNameField.sendKeys(lastName);
    }

    public void selectBirthDay(String birthDay) {
        String[] birthDateParts = birthDay.split(" ");

        String day = birthDateParts[0];
        String month = birthDateParts[1];
        String year = birthDateParts[2];

        Select selectDay = new Select(dropDownMenuDay);
        selectDay.selectByVisibleText(day);

        Select selectMonth = new Select(dropDownMenuMonth);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(dropDownMenuYear);
        selectYear.selectByVisibleText(year);


    }

    public void enterId(String id) {
        idField.clear();
        idField.sendKeys(id);
    }

    public void chooseGender() throws InterruptedException {
        genderList.get(0).click();
        Thread.sleep(5000);
    }

    public void clickOnContinueToPaymentButton() {
        BrowserUtils.scrollToElement(continueToPaymentButton);
        actions.moveToElement(continueToPaymentButton)
                .click().build().perform();
    }


}

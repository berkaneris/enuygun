package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.BrowserUtils;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "label[data-testid='flight-origin-input-comp']")
    private WebElement fromWhereBox;

    @FindBy(css = "label[data-testid='flight-destination-input-comp']")
    private WebElement toWhereBox;

    @FindBy(css = "label[name='flightTrip']")
    private List<WebElement> tripFilter;

    @FindBy(css = "label[data-testid='enuygun-homepage-flight-departureDate-input-comp']")
    private WebElement departureDatePickerBox;
    @FindBy(css = "div[class='sc-ciQpPG fohxuO']")
    private WebElement datePicker;

    @FindBy(css = "label[data-testid='enuygun-homepage-flight-returnDate-input-comp']")
    private WebElement returnDatePickerBox;

    @FindBy(css = "button[type='submit']")
    private WebElement findCheapTicketButton;

    @FindBy(xpath = "//span[contains(text(),'Giriş yap')]")
    private WebElement loginButton;

    @FindBy(css = "input[data-testid='membership-signin-email-input']")
    private WebElement eMailbox;

    @FindBy(css = "input[data-testid='membership-signin-password-input']")
    private WebElement passwordBox;

    @FindBy(css = "button[data-testid='membership-signin-submit-button']")
    private WebElement innerLoginButon;

    @FindBy(xpath = "//span[contains(text(),'Hesabım')]")
    private WebElement hesabimTab;

    public void enterRouteInformation(String fromWhere, String toWhere) {
        BrowserUtils.clickOnElement(fromWhereBox);//TARİH-ROTA PARAMETRİK OLACAK//
        fromWhereBox.sendKeys(fromWhere);
        BrowserUtils.enterText();
        BrowserUtils.clickOnElement(toWhereBox);
        toWhereBox.sendKeys(toWhere);
        BrowserUtils.enterText();
    }

    public void clickOnDepartureDatePicker(String departureDate) {
        BrowserUtils.clickOnElement(departureDatePickerBox);
        boolean isDateSelected = false;
        int count = 0;
        while (!isDateSelected) {
            List<WebElement> elements = datePicker.findElements(By.cssSelector("div[class='sc-bXWnss fMfTLX']"));
            if (departureDate.contains(elements.get(0).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())) {
                String day = departureDate.split(" ")[0];
                List<WebElement> days = elements.get(0).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        BrowserUtils.clickOnElement(days.get(i));
                        isDateSelected = true;
                        break;
                    }
                }
            } else if (departureDate.contains(elements.get(1).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())) {
                String day = departureDate.split(" ")[0];
                List<WebElement> days = elements.get(1).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        BrowserUtils.clickOnElement(days.get(i));
                        isDateSelected = true;
                        break;
                    }
                }
            } else {
                List<WebElement> arrows = datePicker.findElements(By.cssSelector("div[class='sc-cRmqLi iRpHSx'] svg"));
                if (count == 0) {
                    BrowserUtils.clickOnElement(arrows.get(0));
                } else {
                    BrowserUtils.clickOnElement(arrows.get(1));
                }
                count++;
            }
        }


    }

    public void clickOnReturnDatePicker(String returnDate) {
        BrowserUtils.clickOnElement(returnDatePickerBox);
        boolean isDateSelected = false;
        int count = 0;
        while (!isDateSelected) {
            List<WebElement> elements = datePicker.findElements(By.cssSelector("div[class='sc-bXWnss fMfTLX']"));
            if (returnDate.contains(elements.get(0).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())) {
                String day = returnDate.split(" ")[0];
                List<WebElement> days = elements.get(0).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        BrowserUtils.clickOnElement(days.get(i));
                        isDateSelected = true;
                        break;
                    }
                }
            } else if (returnDate.contains(elements.get(1).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())) {
                String day = returnDate.split(" ")[0];
                List<WebElement> days = elements.get(1).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        BrowserUtils.clickOnElement(days.get(i));
                        isDateSelected = true;
                        break;
                    }
                }
            } else {
                List<WebElement> arrows = datePicker.findElements(By.cssSelector("div[class='sc-cRmqLi iRpHSx'] svg"));
                if (count == 0) {
                    BrowserUtils.clickOnElement(arrows.get(0));
                } else {
                    BrowserUtils.clickOnElement(arrows.get(1));
                }
                count++;
            }
        }


    }

    public void clickOnFindButton() {
        BrowserUtils.clickOnElement(findCheapTicketButton);
    }

    public void clickOnRoundTripFilter() {
        BrowserUtils.clickOnElement(tripFilter.get(1));
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void fillEMailBox(String str) {
        eMailbox.click();
        eMailbox.sendKeys(str);
    }

    public void fillPasswordBox(String str) {
        passwordBox.click();
        passwordBox.sendKeys(str);

    }

    public void clickOnInnerLoginButton() {
        innerLoginButon.click();
    }

    public void checkHesabimTab(String str) {
        wait.until(ExpectedConditions.visibilityOf(hesabimTab));
        hesabimTab.getText();
        Assertions.assertEquals(str, hesabimTab.getText());

    }


}

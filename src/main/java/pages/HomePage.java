package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.DriverManager;

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
    private WebElement departureDatePicker;

    @FindBy(css = "label[data-testid='enuygun-homepage-flight-returnDate-input-comp']")
    private WebElement returnDatePicker;

    @FindBy(css = "button[type='submit']")
    private WebElement findCheapTicketButton;

    public void enterRouteInformation(String fromWhere, String toWhere) {
        fromWhereBox.click();
        fromWhereBox.sendKeys(fromWhere);
        BrowserUtils.enterText();
        toWhereBox.click();
        toWhereBox.sendKeys(toWhere);
        BrowserUtils.enterText();
    }

    public void clickOnDepartureDatePicker(String departureDate) {
        departureDatePickerBox.click();
        boolean isDateSelected = false;
        while (!isDateSelected) {
            List<WebElement> elements = departureDatePicker.findElements(By.cssSelector("div[class='sc-bXWnss fMfTLX']"));
            if (departureDate.contains(elements.get(0).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())) {
                String day = departureDate.split(" ")[0];
                List<WebElement> days = elements.get(0).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        days.get(i).click();
                        isDateSelected = true;
                        break;
                    }
                }
            }else if(departureDate.contains(elements.get(1).findElement(By.cssSelector("h3[class='sc-fKMpNL lkJvvP']")).getText())){
                String day = departureDate.split(" ")[0];
                List<WebElement> days = elements.get(1).findElements(By.cssSelector("button[data-testid='datepicker-active-day']"));
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getText().equals(day)) {
                        days.get(i).click();
                        isDateSelected = true;
                        break;
                    }
                }
            }else{
                departureDatePicker.findElement(By.cssSelector("div[class='sc-cRmqLi iRpHSx'] svg")).click();
            }
        }


    }

    public void clickOnReturnDatePicker() {
        returnDatePicker.click();
    }

    public void clickOnFindButton() {
        findCheapTicketButton.click();
    }

    public void clickOnRoundTripFilter() {
        tripFilter.get(1).click();
    }


}

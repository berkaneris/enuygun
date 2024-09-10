package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import utils.BrowserUtils;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Havayolu')]")
    private WebElement airlineTextField;              //Yeni sayfaya geçtiğimizi assert etmek için seçtim//

    @FindBy(css = "div.ctx-filter-departure-return-time.card-header")
    private WebElement departureTimeFilter;

    @FindBy(css = "div.ctx-filter-airline.card-header")
    private WebElement airlineFilter;

    @FindBy(css = "span[class='checkbox  search__filter_airlines-TK --span-1']")
    private WebElement turkishAirlinesCheckBox;


    @FindBy(xpath = "//div[@role='slider' and contains(@class, 'rc-slider-handle')]")
    //(//div[@role='slider' and contains(@class, 'rc-slider-handle')])[1/2] istenen slider konumları //
    private List<WebElement> sliders;


    @FindBy(xpath = "//div[contains(@class, 'flight-departure-time')]")
    private List<WebElement> flights;

    @FindBy(css = "div[class='filter-accordion  '] > div")
    private List<WebElement> flightsFilters;


    public void getAirlineText() {
        airlineTextField.getText();
    }

    public void clickOnDepartureTimeFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(departureTimeFilter));
        BrowserUtils.clickOnElement(departureTimeFilter);


    }

    public void moveTheFirstSlider() throws InterruptedException {
        BrowserUtils.scrollToElement(sliders.get(0));
        Thread.sleep(1000);
        actions.moveToElement(sliders.get(0)).
                dragAndDropBy(sliders.get(0), 100, 0).build().perform();

        Thread.sleep(1000);
    }

    public void moveTheSecondSlider() throws InterruptedException {

        actions.moveToElement(sliders.get(1)).
                dragAndDropBy(sliders.get(1), -60, 0).build().perform();


        Thread.sleep(2000);
    }


    public void clickOnAirlinesFilter() {
        BrowserUtils.clickOnElement(airlineFilter);
    }

    public void clickOnTurkishAirlinesFilter() {
        BrowserUtils.scrollToElement(turkishAirlinesCheckBox);
        actions.moveToElement(turkishAirlinesCheckBox)
                .click().build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void verifyAllFlightHoursAreExpectedHours(String firstHourStr, String secondHourStr) throws InterruptedException {

        LocalTime firstHour = LocalTime.parse(firstHourStr, formatter);
        LocalTime secondHour = LocalTime.parse(secondHourStr, formatter);

        wait.until(ExpectedConditions.visibilityOfAllElements(flights));

        List<LocalTime> times = new ArrayList<>();

        for (WebElement timeElements : flights) {
            String timeText = timeElements.getText();

            LocalTime flightTime;

            try {
                flightTime = LocalTime.parse(timeText, formatter);
                times.add(flightTime);
            } catch (Exception e) {
                // Handle cases where the time format is invalid
                System.out.println("Invalid time format: " + timeText);


            }


        }
        for (LocalTime flightTime : times) {
            Assertions.assertTrue(flightTime.compareTo(firstHour) >= 0 && flightTime.compareTo(secondHour) <= 0,
                    "Flight time is not within the expected range: " + flightTime);
        }

        Thread.sleep(1000);
    }
}

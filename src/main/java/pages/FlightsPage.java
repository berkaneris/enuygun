package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Havayolu')]")
    private WebElement airlineTextField;              //Yeni sayfaya geçtiğimizi assert etmek için seçtim//


    /*@FindBy(css = "div.filter-card.card")    //(//span[@class='card-title'])[4] istenen filtre konumu//
    private List<WebElement> filters; */

    @FindBy(css = "div.ctx-filter-departure-return-time.card-header")
    private WebElement departureTimeFilter;

    @FindBy(css = "div.ctx-filter-airline.card-header")
    private WebElement airlineFilter;

    @FindBy(css = "p.checkbox-only-filter.mb-0.search__filter_airlines_only-TK.--p")
    private WebElement turkishAirlinesCheckBox;


    @FindBy(xpath = "//div[@role='slider' and contains(@class, 'rc-slider-handle')]")
    //(//div[@role='slider' and contains(@class, 'rc-slider-handle')])[1/2] istenen slider konumları //
    private List<WebElement> sliders;


    @FindBy(xpath = "//div[contains(@class, 'flight-departure-time')]")
    private List<WebElement> flights;


    public void getAirlineText() {
        airlineTextField.getText();
    }

    public void clickOnDepartureTimeFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(departureTimeFilter));
        departureTimeFilter.click();


    }

    public void moveTheFirstSlider() {

        actions.moveToElement(sliders.get(0)).
                dragAndDropBy(sliders.get(0), 100, 0).build().perform();


    }

    public void moveTheSecondSlider() throws InterruptedException {

        actions.moveToElement(sliders.get(1)).clickAndHold().moveByOffset(-200, 0).release().build().perform();


        Thread.sleep(10000);
    }


    public void clickOnAirlinesFilter() {
        airlineFilter.click();

    }

    public void clickOnTurkishAirlinesFilter() {
        wait.until(ExpectedConditions.visibilityOf(turkishAirlinesCheckBox));
        actions.moveToElement(turkishAirlinesCheckBox)
                .click().build().perform();
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
            Assertions.assertTrue(flightTime.isAfter(firstHour) && flightTime.isBefore(secondHour),
                    "Flight time is not within the expected range: " + flightTime);
        }

        Thread.sleep(2000);
    }
}

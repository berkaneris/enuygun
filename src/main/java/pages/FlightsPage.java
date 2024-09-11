package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserUtils;

public class FlightsPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Havayolu')]")
    private WebElement airlineTextField;

    @FindBy(css = "div.ctx-filter-departure-return-time.card-header")
    private WebElement departureTimeFilter;

    @FindBy(css = "div.ctx-filter-airline.card-header")
    private WebElement airlineFilter;

    @FindBy(css = "span[class='checkbox  search__filter_airlines-TK --span-1']")
    private WebElement turkishAirlinesCheckBox;


    @FindBy(xpath = "//div[@role='slider' and contains(@class, 'rc-slider-handle')]")
    private List<WebElement> sliders;


    @FindBy(xpath = "//div[contains(@class, 'flight-departure-time')]")
    private List<WebElement> flights;

    @FindBy(css = "div[class='filter-accordion  '] > div")
    private List<WebElement> flightsFilters;

    @FindBy(css = "div[class='summary-average-price']")
    private List<WebElement> flightTicketPrices;

    @FindBy(css = "button[class='action-select-btn tr btn btn-success btn-sm']")
    private List<WebElement> departureTicketSelectionButtons;

    @FindBy(xpath = "//span[contains(text(),'Seç ve İlerle')]")
    private WebElement chooseAndProceedButton;

    @FindBy(xpath = "//div[@id='flight-0' and @data-flight-index='0']")
    private List<WebElement> innerCheapestFlightTickets;

    @FindBy(css = "div[class='provider-package']")
    private List<WebElement> arrivalPackageOptions;

    @FindBy(css = "div[class='flight-list flight-list-return    domesticList']")
    private WebElement arrivals;


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

                System.out.println("Invalid time format: " + timeText);


            }


        }
        for (LocalTime flightTime : times) {
            Assertions.assertTrue(flightTime.compareTo(firstHour) >= 0 && flightTime.compareTo(secondHour) <= 0,
                    "Flight time is not within the expected range: " + flightTime);
        }

        Thread.sleep(1000);
    }

    public void verifyAllTicketsAreInTheAscendingOrder() {

        List<Double> prices = new ArrayList<>();

        wait.until(ExpectedConditions.visibilityOfAllElements(flightTicketPrices));

        for (WebElement ticketPrice : flightTicketPrices) {
            String priceText = ticketPrice.getText();
            priceText = priceText.replace("TL", "").replace(",", ".");

            try {
                Double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Invalid price format: " + priceText);
            }
        }

        List<Double> sortedPrices = new ArrayList<>(prices);

        sortedPrices.sort(Double::compareTo);


        Assertions.assertEquals(prices, sortedPrices, "Flight prices are not in ascending order");

    }

    public void clickOnCheapestDepartureTicketButton() {
        wait.until(ExpectedConditions.visibilityOfAllElements(departureTicketSelectionButtons));
        departureTicketSelectionButtons.get(0).click();
    }

    public void clickOnChooseAndProceedButton() {
        chooseAndProceedButton.click();
    }

    public void clickOnInnerCheapestTicket() {
        List<WebElement> selectButtons = arrivals.findElements(By.cssSelector("button[class='action-select-btn tr btn btn-success btn-sm']"));
        selectButtons.get(0).click();


    }

    public void chooseBasicPackageForArrivalTicket() throws InterruptedException {
        try {

            WebDriverWait wait = new WebDriverWait(DRIVER, Duration.ofSeconds(20));
            List<WebElement> arrivalPackageOptions = DRIVER.findElements(By.cssSelector("div[class='provider-package']"));

            wait.until(ExpectedConditions.elementToBeClickable(arrivalPackageOptions.get(0)));

            BrowserUtils.scrollToElement(arrivalPackageOptions.get(0));
            Actions actions = new Actions(DRIVER);
            actions.moveToElement(arrivalPackageOptions.get(0)).click().build().perform();

        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.println("StaleElementReferenceException caught. Retrying...");
            chooseBasicPackageForArrivalTicket();
        } catch (Exception e) {

            e.printStackTrace();
        }

    }
}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.FlightsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.BrowserUtils;
import utils.DriverManager;

public class FlightsPageSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(FlightsPageSteps.class);

    FlightsPage flightsPage = new FlightsPage();


    @When("the user clicks on Departure Takeoff and Landing time filter")
    public void theClientClicksOnDepartureTakeoffAndLandingTimeFilter() {
        flightsPage.clickOnDepartureTimeFilter();
        LOGGER.debug("The user clicks on Departure Takeoff and Landing Time filter ");
    }

    @And("the user drags the left slider to right")
    public void theClientDragsTheLeftSliderToRight() throws InterruptedException {
        flightsPage.moveTheFirstSlider();
        LOGGER.debug("The user drags the first left slider");
    }


    @And("the user drags the right slider to left")
    public void theClientDragsTheRightSliderToLeft() throws InterruptedException {
        flightsPage.moveTheSecondSlider();
        LOGGER.debug("The user drags the first right slider");
    }


    @Then("the user sees that al flights are between {string} and {string}")
    public void theClientSeesThatAlFlightsAreBetweenAnd(String time1, String time2) throws InterruptedException {
        flightsPage.verifyAllFlightHoursAreExpectedHours(time1, time2);
        LOGGER.debug("The user sees that all flights are in the expected period of time");
    }


    @And("the user clicks on Airlines filter")
    public void theUserClicksOnAirlinesFilter() {
        flightsPage.clickOnAirlinesFilter();
        LOGGER.debug("The user clicks on Airlines Filter");
    }

    @And("the user chooses Türk Hava Yolları")
    public void theUserChoosesTurkHavaYolları() {
        flightsPage.clickOnTurkishAirlinesFilter();
        LOGGER.debug("The user clicks on Türk Hava Yolları checkbox");
    }

    @Then("the user sees the Flights Page")
    public void theUserSeesTheFlightsPage() {
        Assertions.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("https://www.enuygun.com/ucak-bileti"));
        LOGGER.debug("The user sees the Flights Page");
    }

    @Then("the user sees the Türk Hava Yolları tickets in ascending order")
    public void theUserSeesTheTurkHavaYollarıTicketsInAscendingOrder() {
        flightsPage.verifyAllTicketsAreInTheAscendingOrder();
        LOGGER.debug("The use sees the Türk Hava Yolları ticket prices in ascending order");
    }

    @When("the user chooses the cheapest flight for departure")
    public void theUserChoosesTheCheapestFlightForDeparture() {
        flightsPage.clickOnCheapestDepartureTicketButton();
        LOGGER.debug("The user clicks on the cheapest departure ticket button");
    }

    @And("the user chooses Süper Eko package")
    public void theUserChoosesSuperEkoPackage() {
        flightsPage.clickOnChooseAndProceedButton();
        LOGGER.debug("The user chooses Süper Eko package and clicks on Seç ve İlerle Button");

    }

    @And("the user  chooses the cheapest flight for arrival")
    public void theUserChoosesTheCheapestFlightForArrival() {
        flightsPage.clickOnInnerCheapestTicket();
        LOGGER.debug("The user chooses thecheapest flight for arrival");

    }

    @And("the user chooses basic package for arrival")
    public void theUserChoosesBasicPackageForArrival() throws InterruptedException {
        flightsPage.chooseBasicPackageForArrivalTicket();
        LOGGER.debug("The user chooses the basic package for arrival");
    }

}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.FlightsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
        LOGGER.info("The user clicks on Türk Hava Yolları checkbox");
    }

    @Then("the user sees the Flights Page")
    public void theUserSeesTheFlightsPage() {
        Assertions.assertTrue(DriverManager.getDriver().getCurrentUrl().contains("https://www.enuygun.com/ucak-bileti"));
    }
}

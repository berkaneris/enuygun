package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FlightsPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlightsPageSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(FlightsPageSteps.class);

    FlightsPage flightsPage = new FlightsPage();


    @When("the client clicks on Departure Takeoff and Landing time filter")
    public void theClientClicksOnDepartureTakeoffAndLandingTimeFilter() {
        flightsPage.clickOnDepartureTimeFilter();
        LOGGER.debug("The user clicks on Departure Takeoff and Landing Time filter ");
    }

    @And("the client drags the left slider to right")
    public void theClientDragsTheLeftSliderToRight() {
        flightsPage.moveTheFirstSlider();
        LOGGER.debug("The user drags the first left slider");
    }


    @And("the client drags the right slider to left")
    public void theClientDragsTheRightSliderToLeft() throws InterruptedException {
        flightsPage.moveTheSecondSlider();
        LOGGER.debug("The user drags the first right slider");
    }


    @Then("the client sees that al flights are between {string} and {string}")
    public void theClientSeesThatAlFlightsAreBetweenAnd(String time1, String time2) throws InterruptedException {
        flightsPage.verifyAllFlightHoursAreExpectedHours(time1, time2);
        LOGGER.debug("The user sees that all flights are in the expected period of time");
    }


}

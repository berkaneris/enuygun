package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(HomePageSteps.class);
    HomePage homePage = new HomePage();


    @When("i enter the route from {string} to {string}")
    public void iEnterTheRouteFromTo(String fromWhere, String toWhere) {
        homePage.enterRouteInformation(fromWhere, toWhere);
        LOGGER.debug("The user chooses the departure and arrival cities ");
    }

    @And("i choose round trip")
    public void iChooseRoundTrip() throws InterruptedException {
        homePage.clickOnRoundTripFilter();
        homePage.clickOnDepartureDatePicker("16 Ekim 2024");
        Thread.sleep(5000);
        LOGGER.debug("The user chooses round trip and picks up the date ");
    }

    @And("I click on Find Button")
    public void iClickOnFindButton() {
        homePage.clickOnFindButton();
        LOGGER.debug("The user clicks on Find Cheap Tickets button");
    }


}

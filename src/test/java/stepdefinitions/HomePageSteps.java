package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePageSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(HomePageSteps.class);
    HomePage homePage = new HomePage();


    @When("the user enters the route from {string} to {string}")
    public void iEnterTheRouteFromTo(String fromWhere, String toWhere) {
        homePage.enterRouteInformation(fromWhere, toWhere);
        LOGGER.debug("The user chooses the departure and arrival cities ");
    }

    @And("the user chooses round trip and picks the departure date as {string} and the return date as {string}")
    public void theUserChoosesRoundTripAndPicksTheDepartureDateAsAndTheReturnDateAs(String departureDate, String returnDate) {
        homePage.clickOnRoundTripFilter();
        homePage.clickOnDepartureDatePicker(departureDate);
        homePage.clickOnReturnDatePicker(returnDate);
        LOGGER.debug("The user chooses round trip and picks up the date ");
    }

    @And("the user clicks on Find Button")
    public void iClickOnFindButton() {
        homePage.clickOnFindButton();
        LOGGER.debug("The user clicks on Find Cheap Tickets button");
    }


    @When("the user clicks on Login Button")
    public void theUserClicksOnLoginButton() {
        homePage.clickOnLoginButton();
        LOGGER.debug("The user clicks on Login Button");
    }

    @And("the user enters email as {string}")
    public void theUserEntersEmailAs(String str) {
        homePage.fillEMailBox(str);
        LOGGER.debug("The user enters email");

    }

    @And("the user enters password as {string}")
    public void theUserEntersPasswordAs(String str) {
        homePage.fillPasswordBox(str);
        LOGGER.debug("The user enters password");
    }

    @And("the user clicks on Inner Login Button")
    public void theUserClicksOnInnerLoginButton() {
        homePage.clickOnInnerLoginButton();
        LOGGER.debug("The user clicks on inner login button");
    }

    @Then("the user sees the username as {string} on the Hesabım Tab")
    public void theUserSeesTheUserNameOnTheHesabımTab(String str) {
        homePage.checkHesabimTab(str);
        LOGGER.debug("The user sees the username on the Hesabim Tab");
    }


}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.PaymentPage;

public class PaymentPageSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(FlightsPageSteps.class);

    PaymentPage paymentPage = new PaymentPage();



    @When("the user enters the card number as {string}")
    public void theUserEntersTheCardNumberAs(String str) {
        paymentPage.fillCardNumberField(str);
        LOGGER.debug("The user enters the card number");

    }

    @And("the user selects the expiry date as {string}")
    public void theUserSelectsTheExpiryDateAs(String str) {
        paymentPage.selectCardExpiryDate(str);
        LOGGER.debug("The user selects the card expiry date");

    }

    @And("the user enters CVV number as {string}")
    public void theUserEntersCVVNumberAs(String str) {
        paymentPage.fillCvvNumber(str);
        LOGGER.debug("The user fills the CVV Number");

    }

    @And("the user clicks on Pay button")
    public void theUserClicksOnPayButton() {
        paymentPage.clickOnPayButton();
        LOGGER.debug("The user clicks on Pay Button");

    }

    @Then("the user sees that card number is invalid")
    public void theUserSeesThatCardNumberIsInvalid() {
        paymentPage.verifyCardNumberIsInvalid();
        LOGGER.debug("The user sees that card number is invalid");
    }


}

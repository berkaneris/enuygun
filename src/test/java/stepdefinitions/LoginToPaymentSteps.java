package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.PassengerInformationPage;

public class LoginToPaymentSteps extends BaseStep {

    public static final Logger LOGGER = LogManager.getLogger(FlightsPageSteps.class);

    PassengerInformationPage passengerInformationPage = new PassengerInformationPage();

    @Then("the user sees the Passenger Information page as {string} on Passenger Information Page")
    public void theUserSeesThePassengerInformationPage(String str) {

        passengerInformationPage.verifyPassengerInformationPage(str);
        LOGGER.debug("the user sees the Passenger Information page");

    }

    @When("the user fills emailbox as {string} and fills phone number box as {string}")
    public void theUserFillsEmailboxAsAndFillsPhoneNumberBoxAs(String eMail, String number) {
        passengerInformationPage.fillPaymentEmailBoxAndNumber(eMail, number);
        LOGGER.debug("The user fills email and phone number");

    }

    @And("the user enters the name as {string} and enters the surname as {string}")
    public void theUserEntersTheNameAsAndEntersTheSurnameAs(String str1, String str2) {
        passengerInformationPage.fillFirstNameAndLastNameFields(str1, str2);
        LOGGER.debug("The user fills firstName and lastName fields");
    }

    @And("the user selects the birthday as {string}")
    public void theUserChoosesTheSelectsTheBirthdayAs(String birthDate) {
        passengerInformationPage.selectBirthDay(birthDate);
        LOGGER.debug("The user selects the birthDate");

    }

    @And("the user enters the id as {string}")
    public void theUserEntersTheIdAs(String str) {
        passengerInformationPage.enterId(str);
        LOGGER.debug("The user enters the id");

    }

    @And("the user chooses gender")
    public void theUserChoosesGender() throws InterruptedException {
        passengerInformationPage.chooseGender();
        LOGGER.debug("The user chooses the gender");
    }

    @And("the user clicks on Continue To Payment Button")
    public void theUserClicksOnGoToThePaymentButton() {
        passengerInformationPage.clickOnContinueToPaymentButton();
        LOGGER.debug("the user clicks on Continue To Payment Button");

    }


}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.HomePage;

public class HomePageSteps extends BaseStep{
    HomePage homePage = new HomePage();


    @When("i enter the route from {string} to {string}")
    public void iEnterTheRouteFromTo(String fromWhere, String toWhere) {
        homePage.enterRouteInformation(fromWhere, toWhere);
    }

    @And("i choose round trip")
    public void iChooseRoundTrip()  throws InterruptedException {
        homePage.clickOnRoundTripFilter();
        homePage.clickOnDepartureDatePicker("16 Aralık 2024");
        Thread.sleep(5000);
    }
}

Feature: Search Flight

  Scenario: Search RoundTrip Flight
    When the user enters the route from "İstanbul" to "Ankara"

    And i choose round trip

    And I click on Find Button



    When the client clicks on Departure Takeoff and Landing time filter

    And the client drags the left slider to right

    And the client drags the right slider to left

    Then the client sees that al flights are between "10:00" and "18:00"












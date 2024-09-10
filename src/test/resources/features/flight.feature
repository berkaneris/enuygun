Feature: Search Flight

  Scenario: Search RoundTrip Flight
    When  the user enters the route from "İstanbul" to "Ankara"

    And the user chooses round trip and picks the departure date as "11 Ocak 2025" and the return date as "20 Şubat 2025"

    And the user clicks on Find Button

    Then the user sees the Flights Page

    When the user clicks on Departure Takeoff and Landing time filter

    And the user drags the left slider to right

    And the user drags the right slider to left

    Then the user sees that al flights are between "10:00" and "18:00"












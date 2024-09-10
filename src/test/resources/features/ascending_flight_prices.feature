Feature: Search Flight

  Scenario: Search Türk Hava Yolları flights in ascending order

    Given The user is on the ENUYGUN Homepage

    When  the user enter the route from "İstanbul" to "Ankara"

    And   the user chooses round trip and picks the date

    And   the user clicks on Find button

    Then  the user sees the Flights Page


    When  the user clicks on Departure Takeoff and Landing time filter

    And   the user drags the left slider to right

    And   the user drags the right slider to left

    And   the user clicks on Airlines filter

    And   the user chooses Türk Hava Yolları

    Then  the user sees the Türk Hava Yolları tickets in ascending order


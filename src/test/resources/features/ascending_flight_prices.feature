Feature: Search Flight

  Scenario: Search Türk Hava Yolları flights in ascending order


    When  the user enters the route from "İstanbul" to "Ankara"

    And   the user chooses round trip and picks the departure date as "10 Kasım 2024" and the return date as "24 Kasım 2024"

    And   the user clicks on Find Button

    Then  the user sees the Flights Page


    When  the user clicks on Departure Takeoff and Landing time filter

    And   the user drags the left slider to right

    And   the user drags the right slider to left

    And   the user clicks on Airlines filter

    And   the user chooses Türk Hava Yolları

  #  Then  the user sees the Türk Hava Yolları tickets in ascending order


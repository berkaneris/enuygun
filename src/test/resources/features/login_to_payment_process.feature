Feature: Search Flight

  Scenario: Payment with invalid card number
    When the user clicks on Login Button

    And the user enters email as "mssyr07@gmail.com"

    And the user enters password as "123Abc123."

    And the user clicks on Inner Login Button

    Then the user sees the username as "Hesabım" on the Hesabım Tab

    When  the user enters the route from "İstanbul" to "Ankara"

    And the user chooses round trip and picks the departure date as "11 Kasım 2024" and the return date as "20 Kasım 2024"

    And the user clicks on Find Button

    Then the user sees the Flights Page

    When the user clicks on Departure Takeoff and Landing time filter

    And the user drags the left slider to right

    And the user drags the right slider to left

    Then the user sees that al flights are between "10:00" and "18:00"

    When the user chooses the cheapest flight for departure

    And the user chooses Süper Eko package

    And the user  chooses the cheapest flight for arrival

    And the user chooses basic package for arrival

    Then the user sees the Passenger Information page as "İletişim Bilgileri" on Passenger Information Page

    When the user fills emailbox as "mssyr07@gmail.com" and fills phone number box as "05555555555"

    And the user enters the name as "Mert" and enters the surname as "Ahmet"

    And the user selects the birthday as "10 Nisan 1997"

    And the user enters the id as "49672719162"

    And the user chooses gender

    And the user clicks on Continue To Payment Button

    When the user enters the card number as "961561032111561"

    And the user selects the expiry date as "06 2030"

    And the user enters CVV number as "111"

    And the user clicks on Pay button

    Then the user sees that card number is invalid












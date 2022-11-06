Feature: End to end scenario include login, by producs, check webshop carts, logout. Every page and displayed text is verified.


    @Run
    Scenario Outline: EndToEndScenario

      Given I read test data from "SwagLabsData" "SwagLabs" "<row>"
      Given I am logged in
      And I by products
      And I checkedout
      And I clicked menu button
      And I checked menu items
      Given I am logged out

    @Run
      Examples:
        | row |
        | 1   |

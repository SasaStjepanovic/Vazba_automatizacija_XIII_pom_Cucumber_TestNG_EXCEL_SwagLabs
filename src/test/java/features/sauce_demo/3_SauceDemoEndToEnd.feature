Feature: End to end scenario include login, by producs, check webshop carts, logout. Every page and displayed text is verified.


    @Run
    Scenario Outline: EndToEndScenario

      Given I am logged in "<username>" AND "<password>" AND "<testType>" AND "<expectedText>"
      And I by products
      And I checkedout
      And I clicked menu button
      And I checked menu items
      Given I am logged out "<testTypeLogout>" AND "<logoutMessage>"


    Examples:
      | username      |  password   | testType |  expectedText  | testTypeLogout | logoutMessage|
      | standard_user |secret_sauce | positive | PRODUCTS       |      positive  |    Login     |

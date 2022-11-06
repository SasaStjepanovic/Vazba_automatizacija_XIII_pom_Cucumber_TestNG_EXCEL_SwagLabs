Feature: Firstly login, click menu button and press logput button. Every opened page is verified


    @Run
    Scenario Outline: Logout

    Given I am logged in "<username>" AND "<password>" AND "<testType>" AND "<expectedText>"
      And I clicked menu button
    Given I am logged out "<testTypeLogout>" AND "<logoutMessage>"

    @Run
    Examples:
      | username      |  password   | testType |  expectedText  | testTypeLogout | logoutMessage|
      | standard_user |secret_sauce | positive | PRODUCTS       |      positive  |    Login     |

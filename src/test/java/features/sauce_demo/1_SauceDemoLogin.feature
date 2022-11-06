Feature: Valid and invalid login scenarios with different combination of input parameters. Every displayed message is verified

  @Run
  Scenario Outline: Login

    Given I am logged in "<username>" AND "<password>" AND "<testType>" AND "<expectedText>"


    Examples:
      | username                |  password   | testType |  expectedText                                                             |
      | standard_user           |secret_sauce | positive | PRODUCTS                                                                  |
      | locked_out_user         |secret_sauce | negative | Epic sadface: Sorry, this user has been locked out.                       |
      | problem_user            |secret_sauce | positive | PRODUCTS                                                                  |
      | performance_glitch_user |secret_sauce | positive | PRODUCTS                                                                  |
      | yyyyyyyy                |secret_sauce | negative | Epic sadface: Username and password do not match any user in this service |
      | standard_user           |xxxxxxxxxxxx | negative | Epic sadface: Username and password do not match any user in this service |
      |                         |pp           | negative | Epic sadface: Username is required                                        |

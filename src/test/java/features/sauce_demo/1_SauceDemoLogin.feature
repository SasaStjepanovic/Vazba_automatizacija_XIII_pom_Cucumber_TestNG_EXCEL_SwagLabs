Feature: Valid and invalid login scenarios with different combination of input parameters. Every displayed message is verified

  @Run
  Scenario Outline: Login

    Given I read test data from "SwagLabsData" "SwagLabs" "<row>"
    Given I am logged in

  @Run
    Examples:
      | row |
      | 1   |
      | 2   |
      | 3   |
      | 4   |
      | 5   |
      | 6   |
      | 7   |


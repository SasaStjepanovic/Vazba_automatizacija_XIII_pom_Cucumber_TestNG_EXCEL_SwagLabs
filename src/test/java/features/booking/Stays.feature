Feature: Stays

  @Run
  Scenario Outline: Book a stay

    Given I read test data from "SwagLabsData" "Booking" "<row>"
    Given I am on booking stays page
    When I enter destination location
    And I enter check in date
    And I enter check out date
    And I add adults
    And I add children
    And I add rooms
    And I click search button

    Examples:
      | row |
      | 1   |
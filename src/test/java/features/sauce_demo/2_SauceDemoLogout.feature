Feature: Firstly login, click menu button and press logput button. Every opened page is verified


    @Run
    Scenario Outline: Logout

      Given I read test data from "SwagLabsData" "SwagLabs" "<row>"
      Given I am logged in
      And I clicked menu button
      Given I am logged out

      @Run
      Examples:
        | row |
        | 1   |

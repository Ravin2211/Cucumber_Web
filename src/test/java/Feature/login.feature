Feature: BookCart Application
  Scenario: Login should be successful
    Given User should be navigated to application
    And User clicks on the Login Link
    And User gives the valid Username
    And User gives the valid Password
    When User Clicks the Login Button
    Then Login should be Successfull

  Scenario: Login should be failed
    Given User should be navigated to application
    And User clicks on the Login Link
    And User gives the Invalid Username
    And User gives the Invalid Password
    When User Clicks the Login Button
    Then Login should be Failed
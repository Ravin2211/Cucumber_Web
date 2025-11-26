Feature: Examine the admin field

  #similar to @beforeclass annotation
  #  Given User should be able to login

  Scenario Outline: To navigate through the HCm web
    Given User should be able to login
    And Click the Admin Field
    And Select the user name as "<username>"
    When Click the submit button
    Then Records should generate

    Examples:
    |username|
    |Sakya|
    |Nani|
    |Nana|
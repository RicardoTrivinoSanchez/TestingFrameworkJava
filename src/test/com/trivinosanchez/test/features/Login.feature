Feature: Login
  Testing login
  Scenario: Login Flow
    Given a user in the Login page
    When logging as "admin" with password "password"
    Then the user is directed to Home page
    And there is a greeting for the user at the top bar

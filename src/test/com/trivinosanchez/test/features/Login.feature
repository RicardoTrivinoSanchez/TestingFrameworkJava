@Login
Feature: Login
  As a Product Owner
  I want to have a login page
  So the user can log in into the web

  @Web @Smoke
  Scenario: Accessing Login Page
    Given a user in the Home page
    When clicking on Login button
    Then the user is directed to Login page

  @Web
  Scenario: Login Flow
    Given a user in the Login page
    When logging as "admin" with password "password"
    Then the user is directed to Home page
    And there is a greeting for the user at the top bar

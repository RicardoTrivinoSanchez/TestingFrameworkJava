@Login
Feature: Login
  As a Product Owner
  I want to have a login page
  So the user can log in into the web in a secure, easy way

  @Web
  Scenario Outline: Login Flow
    Given a user on <platform> browsing from Chrome
    And the user is in the Home page
    When searching for 'Cervantes'
    Then the user is directed to Cervantes page

    Examples:
      | platform  |
      | Desktop   |
      | WebApp    |

@Login
Feature: Login
  As a Product Owner
  I want to have a login page
  So the user can log in into the web in a secure, easy way

  @Web
  Scenario Outline: Login Flow
    Given a user in the Home page browsing from <browser>
    When searching for 'Cervantes'

    Examples:
      | browser |
      | Chrome  |
      | Firefox |

@TopBar @Navigation
Feature: TopBar
  As a Product Owner
  I want to have a navigation top bar
  So the user can navigate easily through the web

  @Web @Smoke
  Scenario: Accessing Login Page
  Given a user in the Home page
  When clicking on Login link
  Then the user is directed to Login page

  @Web @Smoke
  Scenario: Accessing Employee List Page
  Given a user in the Home page
  When clicking on Employee List link
  Then the user is directed to Employee List page

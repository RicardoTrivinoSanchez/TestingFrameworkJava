@Employee @Create
Feature: Create employee
  As a HR
  I want to be able to add new Employees on the web
  So adding Employees to the database will be easy

  @Web @Smoke
  Scenario: Accessing Create Employee Page
    Given a logged user in the Employee List page
    When clicking on Create New Employee button
    Then the user is directed to Employee Create page

  @Web
  Scenario: Creating an Employee
    Given a logged user in the Employee Create page
    When creating a user
    Then the user is visible in the Employee List

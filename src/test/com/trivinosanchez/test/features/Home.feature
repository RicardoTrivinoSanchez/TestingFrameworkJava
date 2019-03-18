@Login
Feature: Login
  As a Product Owner
  I want to have a login page
  So the user can log in into the web in a secure, easy way

  Scenario Outline: Login Flow
    Given a user on <platform> browsing from Chrome
    And the user is in the Home page
    When searching for 'Cervantes'
    Then the user has been directed to Cervantes page

    @Web
    Examples:
      | platform  |
      | Desktop   |

    @Mobile
    Examples:
      | platform  |
      | WebApp    |


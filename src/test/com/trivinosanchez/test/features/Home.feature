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
    Then the user has been directed to Cervantes page

    @Desktop
    Examples:
      | platform  |
      | Desktop   |

#    @Mobile
#    Examples:
#      | platform  |
#      | WebApp    |

  @Mobile @Android @App
  Scenario: Android Login Flow
    Given a user with the Wikipedia app on Android
    And the user is in the Home page on Android
    When searching for 'Cervantes'
    Then the user has been directed to Cervantes page on Android

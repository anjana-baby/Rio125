Feature: Cutomer Front-End Functionality of PHPTravels user page

  Background: 
    Given I am on the PHPTravels user login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on the My Profile link
    Then I should be redirected to the My Profile page
    Then I should be able to update the address
    When I click on the My Bookings link
    Then I should be redirected to the My Bookings page
    When I Click on view voucher
    Then voucher should be displayed
    When I click on Add Funds
    Then I should be able to transfer amount using PayPal

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on Add Funds
    Then I should be able to transfer amount using PayPal

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    When I click on the Logout link
    Then I should be redirected to the Home page

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see an error message

    Examples: 
      | email               | password |
      | userphptravels.com  | demo     |
      | user@               | demouser |
      |                     | demouser |
      | user@phptravels.com |          |
      |                     |          |

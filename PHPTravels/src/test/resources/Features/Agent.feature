Feature: Agent Front-End Functionality of PHPTravels user page

  Background: 
    Given I am on the PHPTravels agent login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on Hotels link
    Then I should be redirected to Hotels Page
    When I type letters on Search hotels by City
    Then I should be able to find hotels in the mentioned city
    When I click on Flights link
    Then I should be redirected to Flights Page
    When I click on Tours link
    Then I should be redirected to Tours Page
    When I click on Visa link
    Then I should be redirected to Visa Page
    When I click on Blog link
    Then I should be redirected to Blog Page
    When I click on Offers link
    Then I should be redirected to Offers Page
    When I click on Home link
    Then I should be redirected to Home Page
    When I click on the currency dropdown list
    Then I should be able to select INR

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on the My Bookings link
    Then I should be redirected to the My Bookings page
    When I click on Add Funds
    Then I should be redirected to AddFunds Page
    When I click on the My Profile link
    Then I should be redirected to the My Profile page
    When I click on the Logout link
    Then I should be redirected to the Home page

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see an error message

    Examples: 
      | email                | password  |
      | agentphptravels.com  | demo      |
      | agent@               | demoagent |
      |                      | demoagent |
      | agent@phptravels.com |           |
      |                      |           |

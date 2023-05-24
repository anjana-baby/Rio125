Feature: Supplier Back-End Functionality of PHPTravels supplier page

  Background: 
    Given I am on the PHPTravels supplier login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    Then the text Sales Oveview and Summary should be displayed
    Then the text Revenue Breakdown should be displayed
    When I click on Bookings link
    Then I should be redirected to Bookings page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on Flights link
    Then I should be redirected to Flights Page
    When I click on Tours link
    Then I should be redirected to Tours Page
    When I click on Visa link
    Then I should be redirected to Visa Page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on pending bookings  I should be able to update the status to confirmed and
    Then Verify the count

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see an error message

    Examples: 
      | email                   | password     |
      | supplierphptravels.com  | demo         |
      | supplier@               | demosupplier |
      |                         | demosupplier |
      | supplier@phptravels.com |              |
      |                         |              |

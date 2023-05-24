Feature: Admin Back-End Functionality of PHPTravels admin page

  Background: 
    Given I am on the PHPTravels admin login page

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on Paid bookings I should see the invoices

  Scenario: Successful login with valid credentials
    Given I have entered a valid username and password
    When I click on the login button
    Then I should be logged in successfully
    When I click on cancelled bookings  I should be able to delete the records
    When I click on pending bookings  I should be able to update the status to confirmed and
    Then Verify the count
    When I click on Website link
    Then I should be redirected to website page

  Scenario Outline: Unsuccessful login with invalid or empty credentials
    Given I have entered invalid "<email>" and "<password>"
    When I click on the login button
    Then I should see an error message

    Examples: 
      | email                | password  |
      | adminphptravels.com  | demo      |
      | admin@               | demoadmin |
      |                      | demoadmin |
      | admin@phptravels.com |           |
      |                      |           |

package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.SupplierLinks;
import Pages.SupplierLogin;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class SupplierStepDef {
	WebDriver driver = new ChromeDriver();
	 SupplierLogin loginPage=new SupplierLogin(driver);
	 SupplierLinks link=new SupplierLinks(driver);
	 @After
	    public void tearDown(){
	        if(driver!=null){
	            driver.quit();
	        }
	    }
	
	@Given("I am on the PHPTravels supplier login page")
	public void i_am_on_the_php_travels_supplier_login_page() throws InterruptedException {
		driver.get("https://phptravels.net/api/supplier");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("supplier@phptravels.com");
      loginPage.enterPassword("demosupplier");
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I click on the login button")
	public void i_click_on_the_login_button() throws InterruptedException {
		loginPage.clickLoginButton();
		Thread.sleep(3000);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() throws InterruptedException {
		String logout=loginPage.checkLogoutLink();
		//System.out.println(logout);
		Assert.assertEquals(logout, "Docs");
		Thread.sleep(3000);
	   // throw new io.cucumber.java.PendingException();
	}
	@Given("I have entered invalid {string} and {string}")
	public void i_have_entered_invalid_and(String email, String password) {
		 loginPage.enterEmail(email);
	        loginPage.enterPassword(password);
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("I should see an error message")
	public void i_should_see_an_error_message_() {
		Assert.assertEquals(loginPage.urlReturn(),"https://phptravels.net/api/supplier");
	}
	@Then("the text Sales Oveview and Summary should be displayed")
	public void the_text_sales_oveview_and_summary_should_be_displayed() {
	   
		 Assert.assertEquals(link.checkSalesText(), true);
}
	@Then("the text Revenue Breakdown should be displayed")
	public void the_text_revenue_breakdown_should_be_displayed() {
		 Assert.assertEquals(link.checkRevenueText(), true);
	}
	@When("I click on Flights link")
	public void i_click_on_flights_link() throws InterruptedException {
	    //link.clickWebsite();
	   // Thread.sleep(10000);
		driver.get("https://phptravels.net/");
		link.clickFlights();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Flights Page")
	public void i_should_be_redirected_to_flights_page() {

		Assert.assertTrue(link.returnURL().contains("flights"));
	}
	@When("I click on Tours link")
	public void i_click_on_tours_link() throws InterruptedException {
		//link.clickWebsite();
	   // Thread.sleep(10000);
		
		link.clickTours();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Tours Page")
	public void i_should_be_redirected_to_tours_page() {

		Assert.assertTrue(link.returnURL().contains("tours"));
	}
	
	@When("I click on Visa link")
	public void i_click_on_visa_link() throws InterruptedException {
	    link.clickVisa();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Visa Page")
	public void i_should_be_redirected_to_visa_page() {

		Assert.assertTrue(link.returnURL().contains("visa"));
	}

@When("I click on Bookings link")
public void i_click_on_bookings_link() throws InterruptedException {
   link.clickBookings();
   Thread.sleep(5000);
}

@Then("I should be redirected to Bookings page")
public void i_should_be_redirected_to_bookings_page() {
   Assert.assertNotEquals("An Error Was Encountered", link.returnBookings());
}
@When("I click on pending bookings  I should be able to update the status to confirmed and")
public void i_click_on_pending_bookings_i_should_be_able_to_update_the_status_to_confirmed_and() throws InterruptedException {
    link.pendingToConfirmed();
}

@Then("Verify the count")
public void verify_the_count() {
   Assert.assertEquals(link.initialCountReturn(), true);
}
}
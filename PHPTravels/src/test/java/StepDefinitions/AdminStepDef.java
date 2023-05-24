
package StepDefinitions;

import static org.testng.AssertJUnit.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.AdminLinks;
import Pages.AdminLogin;

import io.cucumber.java.*;
import io.cucumber.java.en.*;

public class AdminStepDef {
	WebDriver driver = new ChromeDriver();
	 AdminLogin loginPage=new AdminLogin(driver);
	 AdminLinks link=new AdminLinks(driver);
	 @After
	    public void tearDown(){
	        if(driver!=null){
	            driver.quit();
	        }
	    }
	
	@Given("I am on the PHPTravels admin login page")
	public void i_am_on_the_php_travels_admin_login_page() throws InterruptedException {
		driver.get("https://phptravels.net/api/admin");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("admin@phptravels.com");
       loginPage.enterPassword("demoadmin");
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
		Assert.assertEquals(loginPage.urlReturn(),"https://phptravels.net/api/admin");
	}
	@When("I click on Website link")
	public void i_click_on_website_link() throws InterruptedException {
	   link.clickWebsite();
	   Thread.sleep(10000);
	}

	@Then("I should be redirected to website page")
	public void i_should_be_redirected_to_website_page() {
		driver.get("https://phptravels.net/");
		Assert.assertEquals(link.checkdashboarText(), true);

	}
	
	@When("I click on Paid bookings I should see the invoices")
	public void i_click_on_paid_bookings_i_should_see_the_invoices() throws InterruptedException {
		link.paidInvoiceDisplay();
		Thread.sleep(2000);
	    
	}


	@When("I click on cancelled bookings  I should be able to delete the records")
	public void i_click_on_cancelled_bookings_i_should_be_able_to_delete_the_records() throws InterruptedException {
	    link.deleteCancelled();
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

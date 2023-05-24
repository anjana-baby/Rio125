package StepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



import Pages.CustomerLogin;
import Pages.Links;
import Utility.ExcelUtility;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class CustomerLoginStepDef {
	
	 WebDriver driver = new ChromeDriver();

 
    	 CustomerLogin loginPage=new CustomerLogin(driver);
    	 Links link=new Links(driver);
    	
       
  
    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }
	
	
	@Given("I am on the PHPTravels user login page")
	public void i_am_on_the_php_travels_user_login_page() throws InterruptedException {
	    driver.get("https://phptravels.net/login");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	   // throw new io.cucumber.java.PendingException();
	}

	@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("user@phptravels.com");
        loginPage.enterPassword("demouser");
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
		System.out.println(logout);
		Assert.assertEquals("Recent Searches", logout);
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
		Assert.assertEquals(loginPage.urlReturn(),"https://phptravels.net/login");
	}
	
	
	@When("I click on the My Bookings link")
	public void i_click_on_the_link() throws InterruptedException {
link.clickMyBookings();
Thread.sleep(4000);
	}

	@Then("I should be redirected to the My Bookings page")
	public void i_should_be_redirected_to_the_my_bookings_page() {
		System.out.println(link.checkMyBookingsURL());
		  Assert.assertEquals(link.checkMyBookingsURL(),"https://phptravels.net/account/bookings");
	}
	@When("I Click on view voucher")
	public void i_click_on_view_voucher() throws InterruptedException {
		link.clickVoucher();
		Thread.sleep(7000);
	}
	 @Then ("voucher should be displayed")
	 public void voucher_should_be_displayed()
	 {System.out.println(link.checkVoucherURL());
		 Assert.assertEquals("https://phptravels.net/account/bookings",link.checkVoucherURL());
		// driver.close();
	 }
	@When("I click on the My Profile link")
	public void i_click_on_the_my_profile_link() throws InterruptedException {
	  link.clickMyProfile();
	  Thread.sleep(4000);
	}

	@Then("I should be redirected to the My Profile page")
	public void i_should_be_redirected_to_the_my_profile_page() {
	   Assert.assertTrue(link.checkMyProfileURL().contains("profile"));
	}

	@When("I click on the Logout link")
	public void i_click_on_the_logout_link() throws InterruptedException {
	    link.clickLogout();
	    Thread.sleep(4000);
	}

	@Then("I should be redirected to the Home page")
	public void i_should_be_redirected_to_the_home_page() {
		Assert.assertTrue(link.checkLogoutURL().contains("login"));
	    
	}
	
	@Then("I should be able to update the address")
	public void i_should_be_able_to_update_the_address() throws IOException, InterruptedException {
		String address=ExcelUtility.getCellData(0, 0, System.getProperty("user.dir")+"\\src\\main\\resources\\Excel.xlsx", 0);
		//link.enterAddress("");
		link.enterAddress(address);
		Thread.sleep(5000);
	}
	
	@When("I click on Add Funds")
	public void i_click_on_add_funds() throws InterruptedException {
		link.fundTransfer();
		Thread.sleep(5000);
	    
	}

	@Then("I should be able to transfer amount using PayPal")
	public void i_should_be_able_to_transfer_amount_using_pay_pal() {
		Assert.assertEquals(link.checkPayURL(), "https://phptravels.net/payment/paypal");
		link.returntoDashboard();
	    
	}
}





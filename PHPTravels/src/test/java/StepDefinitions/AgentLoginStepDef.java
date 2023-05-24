package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Pages.AgentLinks;
import Pages.AgentLogin;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

public class AgentLoginStepDef {
	
	 WebDriver driver = new ChromeDriver();
	 AgentLogin loginPage=new AgentLogin(driver);
	 AgentLinks link=new AgentLinks(driver);
	 @After
	    public void tearDown(){
	        if(driver!=null){
	            driver.quit();
	        }
	    }
	
	@Given("I am on the PHPTravels agent login page")
	public void i_am_on_the_php_travels_agent_login_page() throws InterruptedException {
		driver.get("https://phptravels.net/login");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
	    
	}@Given("I have entered a valid username and password")
	public void i_have_entered_a_valid_username_and_password() {
		loginPage.enterEmail("agent@phptravels.com");
        loginPage.enterPassword("demoagent");
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
	@When("I click on Add Funds")
	public void i_click_on_add_funds() throws InterruptedException {
		link.fundTransfer();
		Thread.sleep(5000);
	}

	@Then("I should be redirected to AddFunds Page")
	public void i_should_be_redirected_to_add_funds_page() {

		 Assert.assertEquals(link.checkPayURL(),"https://phptravels.net/account/add_funds");
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
	
	@When("I click on Hotels link")
	public void i_click_on_hotels_link() throws InterruptedException {
	    link.clickHotels();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Hotels Page")
	public void i_should_be_redirected_to_hotels_page() {

		Assert.assertTrue(link.returnURL().contains("hotels"));
	}
	
	@When("I click on Flights link")
	public void i_click_on_flights_link() throws InterruptedException {
	    link.clickFlihghts();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Flights Page")
	public void i_should_be_redirected_to_flights_page() {

		Assert.assertTrue(link.returnURL().contains("flights"));
	}
	@When("I click on Tours link")
	public void i_click_on_tours_link() throws InterruptedException {
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
	@When("I click on Blog link")
	public void i_click_on_blog_link() throws InterruptedException {
	    link.clickBlog();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Blog Page")
	public void i_should_be_redirected_to_blog_page() {

		Assert.assertTrue(link.returnURL().contains("blog"));
	}
	
	@When("I click on Offers link")
	public void i_click_on_offers_link() throws InterruptedException {
	    link.clickOffers();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Offers Page")
	public void i_should_be_redirected_to_offers_page() {

		Assert.assertTrue(link.returnURL().contains("offers"));
	}
	@When("I click on Home link")
	public void i_click_on_home_link() throws InterruptedException {
	    link.clickHome();
	    Thread.sleep(2000);
	}

	@Then("I should be redirected to Home Page")
	public void i_should_be_redirected_to_home_page() {

		Assert.assertEquals(link.returnURL(),"https://phptravels.net/");
	}
	
	@When("I click on the currency dropdown list")
	public void i_click_on_the_currency_dropdown_list() throws InterruptedException {
	   link.clickUSD();
	   Thread.sleep(2000);
	}

	@Then("I should be able to select INR")
	public void i_should_be_able_to_select_inr() throws Exception {
		if(!"INR".equals(link.currencyReturn())) {
		    throw new Exception("Incorrect option selected");
		}
	}
	
	@When("I type letters on Search hotels by City")
	public void i_type_letters_on_search_hotels_by_city() throws InterruptedException {

link.searchbyName();
Thread.sleep(3000);
	}

	@Then("I should be able to find hotels in the mentioned city")
	public void i_should_be_able_to_find_hotels_in_the_mentioned_city() {
		Assert.assertEquals(link.returnHotelText(),"SEARCH HOTELS IN DUBAI");
	   
	}

}
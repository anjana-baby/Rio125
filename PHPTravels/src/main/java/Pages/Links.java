package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {
	 WebDriver driver;
	 //public By AccountLocator=By.xpath("//button[contains(.,'Account')]");
	// public By MyBookingsLinkLocator=By.xpath("//a[@href='https://phptravels.net/account/bookings']");
	 public By MyBookingsLinkLocator=By.linkText("My Bookings");
	// public By MyProfileLinkLocator=By.xpath("//a[@href='https://phptravels.net/account/profile']");
	 public By MyProfileLinkLocator=By.linkText("My Profile");
	// public By LogoutLinkLocator=By.xpath("//a[@href='https://phptravels.net/account/logout']");
	 public By LogoutLinkLocator=By.linkText("Logout");
	 public By VoucherLinkLocator=By.linkText("View Voucher");
	 public By invoice=By.linkText("Booking Invoice");
	 public By addressLocator = By.name("address1");
	 public By updateAddress=By.xpath("//button[text()='Update Profile']");
	 public By addFundsLinkLocator=By.linkText("Add Funds");
	 public By paypalLocator=By.xpath("//input[@value='paypal']");
	 public By payNowLocator=By.xpath("//button[text()='Pay Now ']");
	 public By backLocator=By.linkText("Back to Invoice");
	 public By yesLocator=By.linkText("Yes");
	 
	 public Links(WebDriver driver)
	 {
		 this.driver=driver;
	 }
	 
	 public void clickMyBookings()
	 {
		//WebElement acnt=driver.findElement(AccountLocator);
		 WebElement mybookings=driver.findElement(MyBookingsLinkLocator);
		// acnt.click();
		 mybookings.click();
	 }
	 public void clickMyProfile()
	 {//WebElement acnt=driver.findElement(AccountLocator);
		WebElement myprofile=driver.findElement(MyProfileLinkLocator);
		//acnt.click();
		myprofile.click();
	 }
	 public void clickLogout()
	 {//WebElement acnt=driver.findElement(AccountLocator);
		 WebElement logout=driver.findElement(LogoutLinkLocator);
		// acnt.click();
		 logout.click();
	 }
	 
	 public String checkMyProfileURL()
	 {
		 String myProfileURL=driver.getCurrentUrl();
		 return myProfileURL;
	 }
	 public String checkMyBookingsURL()
	 {
		 String myBookingsURL=driver.getCurrentUrl();
		 return myBookingsURL;
	 }
	 
	 public String checkLogoutURL()
	 {
		 String logoutURL=driver.getCurrentUrl();
		 return logoutURL;
	 }
	 public void clickVoucher()
	 {
		 WebElement Voucher=driver.findElement(VoucherLinkLocator);
		 Voucher.click();
	 }
	 public String checkVoucherURL()
	 {
		 return driver.getCurrentUrl();
		// WebElement bookinginvoice=driver.findElement(invoice);
		 //return bookinginvoice.getText();
	 }
	 public void enterAddress(String address) {
	        WebElement addressInput = driver.findElement(addressLocator);
	        addressInput.clear();
	        addressInput.sendKeys(address);
	       
	    }
	 public void clickUpdate()
	 {
		 WebElement update=driver.findElement(updateAddress);
	        update.click();
	 }
	
	public void fundTransfer() throws InterruptedException
	{
		WebElement fund=driver.findElement(addFundsLinkLocator);
		fund.click();
		Thread.sleep(3000);
		WebElement paypal=driver.findElement(paypalLocator);
		paypal.click();
		WebElement pay=driver.findElement(payNowLocator);
		pay.click();
	}
	public String checkPayURL()
	{
		return driver.getCurrentUrl();
	}
	public void returntoDashboard()
	{
		/*WebElement back=driver.findElement(backLocator);
		back.click();
		WebElement yes=driver.findElement(yesLocator);
		yes.click();*/
		driver.navigate().back();
	}
}

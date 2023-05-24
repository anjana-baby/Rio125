package Pages;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AgentLinks {
	 WebDriver driver;
	 public By MyBookingsLinkLocator=By.linkText("My Bookings");
	 public By MyProfileLinkLocator=By.linkText("My Profile");
	 public By addFundsLinkLocator=By.linkText("Add Funds");
	 public By LogoutLinkLocator=By.linkText("Logout");
	 public By HotelsLinkLocator=By.xpath("//a[@title='hotels']");
	 public By FlightsLinkLocator=By.xpath("//a[@title='flights']");
	 public By ToursLinkLocator=By.xpath("//a[@title='tours']");
	 public By VisaLinkLocator=By.xpath("//a[@title='visa']");
	 public By BlogLinkLocator=By.xpath("//a[@title='blog']");
	 public By OffersLinkLocator=By.xpath("//a[@title='offers']");
	 public By HomeLinkLocator=By.xpath("//a[@href='https://phptravels.net/']");
	 public By CurrencyLinkLocator=By.xpath("//button[@id='currency']");
	 public By SearchHotels_1=By.xpath("//span[@id=\"select2-hotels_city-container\"]");
	 public By SearchHotels=By.xpath("//*[@id=\"fadein\"]/span/span/span[1]/input");
	 public By serachLinkLocator=By.xpath("//button[@id='submit']");
	 
	 public AgentLinks(WebDriver driver)
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
	 
	 public String checkMyBookingsURL()
	 {
		 String myBookingsURL=driver.getCurrentUrl();
		 return myBookingsURL;
	 }
	 public void fundTransfer()
		{
			WebElement fund=driver.findElement(addFundsLinkLocator);
			fund.click();
		}
	 public String checkPayURL()
		{
			return driver.getCurrentUrl();
		}
	 
	 public void clickMyProfile()
	 {//WebElement acnt=driver.findElement(AccountLocator);
		WebElement myprofile=driver.findElement(MyProfileLinkLocator);
		//acnt.click();
		myprofile.click();
	 }
	 public String checkMyProfileURL()
	 {
		 String myProfileURL=driver.getCurrentUrl();
		 return myProfileURL;
	 }
	 public void clickLogout()
	 {//WebElement acnt=driver.findElement(AccountLocator);
		 WebElement logout=driver.findElement(LogoutLinkLocator);
		// acnt.click();
		 logout.click();
	 }
	 public String checkLogoutURL()
	 {
		 String logoutURL=driver.getCurrentUrl();
		 return logoutURL;
	 }
	 
	public void clickHotels()
	{
		WebElement hotel=driver.findElement(HotelsLinkLocator);
		hotel.click();
	}
	
	public String returnURL()
	{
		return driver.getCurrentUrl();
	}
	
	public void clickFlihghts()
	{
		WebElement flight=driver.findElement(FlightsLinkLocator);
		flight.click();
	}
	public void clickTours()
	{
		WebElement tours=driver.findElement(ToursLinkLocator);
		tours.click();
	}
	public void clickVisa()
	{
		WebElement visa=driver.findElement(VisaLinkLocator);
		visa.click();
	}
	
	public void clickBlog()
	{
		WebElement blog=driver.findElement(BlogLinkLocator);
		blog.click();
	}
	public void clickOffers()
	{
		WebElement offers=driver.findElement(OffersLinkLocator);
		offers.click();
	}
	
	public void clickHome()
	{
		WebElement home=driver.findElement(HomeLinkLocator);
		home.click();
	}
	public void clickUSD()
	{
		WebElement usd=driver.findElement(CurrencyLinkLocator);
		usd.click();
		Actions actions = new Actions(driver);
		By pathOfSelection = By.xpath("//a[@href='https://phptravels.net/currency-INR']"); 
		WebElement option = null;
		try {
		   option =driver.findElement(pathOfSelection);
		} catch(NoSuchElementException e){
		   System.out.println("No such option. " + e.getMessage());
		   throw e;
		}
		option.click();
		
	}
	public void changeCurrency()
	{
		Select se=new Select(driver.findElement(CurrencyLinkLocator));
		se.selectByVisibleText("INR");
	}
public String currencyReturn()
{WebElement usd=driver.findElement(CurrencyLinkLocator);
	return usd.getText();
}
public void searchbyName() throws InterruptedException
{
	WebElement hotelSearch_1=driver.findElement(SearchHotels_1);
	hotelSearch_1.click();
	WebElement hotelSearch=driver.findElement(SearchHotels);
	
	Thread.sleep(3000);
	//WebElement hotelSearch=driver.findElement(SearchHotels);
	//System.out.println(letter);
	hotelSearch.sendKeys("DUBAI");
	Thread.sleep(2000);
	hotelSearch.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	WebElement search=driver.findElement(serachLinkLocator);
	search.click();
	
	        }
public String returnHotelText()
{
	WebElement hotelText=driver.findElement(By.xpath("//h2[text()='Search Hotels in dubai']"));
	return hotelText.getText();
}

	    

}

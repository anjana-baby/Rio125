package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SupplierLinks {
	WebDriver driver;
	public By TextLinkLocator= By.xpath("//div[@class='text-muted']");
	public By RevenueTextLinkLocator=By.xpath("//h2[@class='card-title mb-0']");
	public By WebsieLinkLocator=By.xpath("//a[text()='Website']");
	 public By FlightsLinkLocator=By.xpath("//a[@title='flights']");
	 public By ToursLinkLocator=By.xpath("//a[@title='tours']");
	 public By VisaLinkLocator=By.xpath("//a[@title='visa']");
	 public By bookingsLinkLocator=By.xpath("//a[@href='https://phptravels.net/api/supplier/bookings']");
	 public By pendingbookingsLinkLocator=By.xpath("//div[text()='Pending Bookings']");
	 public By pendingTableLocator=By.xpath("//*[@id=\"data\"]");
	 public By countLocator=By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/div[2]/div[2]/a/div/div/div/div[1]/div[1]");
	 int icount,fcount;
	
	public SupplierLinks(WebDriver driver)
	{
		this.driver=driver;
	}
	 public boolean checkSalesText(){
	        return driver.findElement(TextLinkLocator).isDisplayed();
	    }
	 public boolean checkRevenueText(){
	        return driver.findElement(RevenueTextLinkLocator).isDisplayed();
	    }
	 public void clickWebsite()
	 {
		 WebElement website=driver.findElement(WebsieLinkLocator);
		 website.click();
	 }
	 
	 public String returnURL()
		{
			return driver.getCurrentUrl();
		}
		
		public void clickFlights()
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
public void clickBookings()
{
	WebElement bookings=driver.findElement(bookingsLinkLocator);
	bookings.click();
}
public String returnBookings()
{
	WebElement errorMsg=driver.findElement(By.xpath("//h1[text()='An Error Was Encountered']"));
String Msg=errorMsg.getText();
	return Msg;
}
public void pendingToConfirmed() throws InterruptedException {
	WebElement count=driver.findElement(countLocator);
	String pendingCount=count.getText();
 icount=Integer.parseInt(pendingCount);
	WebElement pending=driver.findElement(pendingbookingsLinkLocator);
	pending.click();
	Thread.sleep(3000);
	
	Select se=new Select(driver.findElement(By.xpath("//*[@id=\"booking_status\"]")));
	//System.out.println(pcount);
	se.selectByIndex(1);
	Thread.sleep(2000);
	driver.navigate().back();
	WebElement countf=driver.findElement(countLocator);
	String pendingCountf=countf.getText();
	Thread.sleep(2000);
	int fcount=Integer.parseInt(pendingCountf);
	if(icount==fcount+1)
		initialCountReturn();
}
public boolean initialCountReturn()
{
	
	

	
	
	return true;
	

}
}



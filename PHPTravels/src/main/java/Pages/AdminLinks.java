package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminLinks {
	WebDriver driver;
	public By showLinks=By.xpath("//select[@name='data_length']");
	public By websiteLinkLocator=By.xpath("//a[text()='Website']");
	public By dashboardLinkLocatore=By.xpath("//strong[text()=' Let’s book your next trip!']");
	public By bookingsLinkLocator=By.xpath("//a[text()='Bookings']");
	public By paidbookingsLinkLocator=By.xpath("//div[text()='Paid Bookings']");
	public By cancelledbookingsLinkLocator=By.xpath("//a[@href='https://phptravels.net/api/admin/bookings/cancelled']");
	public By pendingbookingsLinkLocator=By.xpath("//div[text()='Pending Bookings']");
	public By paidTableLink=By.xpath("//*[@id=\"data\"]/tbody/tr");
	public By cancelledTableLink=By.xpath("//*[@id=\"data\"]");
	public By countLocator=By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div[2]/a/div/div/div/div[1]/div[1]");
	public By pendingTableLocator=By.xpath("//*[@id=\"data\"]");
	int icount,fcount;
	public AdminLinks(WebDriver driver)
	{
		this.driver=driver;
	}
public void selctShowCount()
{
	WebElement show=driver.findElement(showLinks); 
	Select se=new Select(show);
	se.selectByValue("25");
}
public void clickWebsite() throws InterruptedException
{
	WebElement website=driver.findElement(websiteLinkLocator);
	website.click();
	Thread.sleep(3000);
}
public String returnURL()
{
	return driver.getCurrentUrl();
}
public boolean checkdashboarText(){
    return driver.findElement(dashboardLinkLocatore).isDisplayed();
}
public void paidInvoiceDisplay() throws InterruptedException

{

	WebElement paid=driver.findElement(paidbookingsLinkLocator);
paid.click();
Thread.sleep(3000);
selctShowCount();
	List < WebElement > rows = driver.findElements(paidTableLink);
int no_of_rows=rows.size();
   
   WebElement invoice= driver.findElement(By.xpath("//*[@id=\"data\"]/tbody/tr[1]/td[14]/a"));
//System.out.println(no_of_rows);
   invoice.click();
   Thread.sleep(12000);
  // driver.close();

	
}
public String ststusReturn() throws InterruptedException
{
	WebElement status=driver.findElement(By.xpath("//strong[@class='ttc']"));
	Thread.sleep(6000);
	return status.getText();
}
public void deleteCancelled() throws InterruptedException
{
	WebElement cancelled=driver.findElement(cancelledbookingsLinkLocator);
	cancelled.click();
	Thread.sleep(3000);
	List < WebElement > rows = driver.findElements(cancelledTableLink);
	int no_of_rows=rows.size();
	System.out.println(no_of_rows);
	WebElement delete=driver.findElement(By.xpath("//*[@id=\"data\"]/tbody/tr[1]/td[15]"));
	delete.click();
	Thread.sleep(5000);
	 Alert alert = driver.switchTo().alert();
	 alert.accept();
	 Thread.sleep(3000);
	 driver.navigate().refresh();
}
public void pendingToConfirmed() throws InterruptedException {
	WebElement pending=driver.findElement(pendingbookingsLinkLocator);
	pending.click();
	Thread.sleep(3000);
	WebElement count=driver.findElement(countLocator);
	String pendingCount=count.getText();
 icount=Integer.parseInt(pendingCount);
	Select se=new Select(driver.findElement(By.xpath("//*[@id=\"booking_status\"]")));
	//System.out.println(pcount);
	se.selectByIndex(1);
	Thread.sleep(2000);
	driver.navigate().refresh();
	WebElement countf=driver.findElement(countLocator);
	String pendingCountf=countf.getText();
	int fcount=Integer.parseInt(pendingCountf);
	if(icount==fcount+1)
		initialCountReturn();
}
public boolean initialCountReturn()
{
	
	

	
	
	return true;
	

}
}

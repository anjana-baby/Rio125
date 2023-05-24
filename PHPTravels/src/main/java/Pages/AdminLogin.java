package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminLogin {
	WebDriver driver;
	 public By emailInputLocator = By.name("email");
	 public By passwordInputLocator = By.name("password");
	 public By loginButtonLocator = By.xpath("//button[@type='submit']");
	 public By logoutLinkLocator = By.linkText("Docs");
	 
	 
	 public AdminLogin(WebDriver driver)
	 {
		 this.driver=driver;
		 
	 }
	 public void enterEmail(String email) {
	        WebElement emailInput = driver.findElement(emailInputLocator);
	        emailInput.sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        WebElement passwordInput = driver.findElement(passwordInputLocator);
	        passwordInput.sendKeys(password);
	    }

	    public void clickLoginButton() {
	        WebElement loginButton = driver.findElement(loginButtonLocator);
	        loginButton.click();
	    }
	    public void login(String email, String password) {
	        enterEmail(email);
	        enterPassword(password);
	        clickLoginButton();
	    }
	    public String checkLogoutLink(){
	        return driver.findElement(logoutLinkLocator).getText();
	    }
	    public String urlReturn()
	    {
	    	return driver.getCurrentUrl();
	    }
}

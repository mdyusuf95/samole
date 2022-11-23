package PageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	@FindBy(name ="user_name")
  private WebElement usernamebox;
	
	@FindBy(name="user_password")
	  private WebElement Passwordbox;
	
	@FindBy(id="submitButton")
	  private WebElement submitbtton;
	
	public LogInPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getUsernamebox() {
		return usernamebox;
	}

	public WebElement getPasswordbox() {
		return Passwordbox;
	}

	public WebElement getSubmitbtton() {
		return submitbtton;
	}

	public void SetLogIn(String username,String password)
	{
		usernamebox.sendKeys(username);
		Passwordbox.sendKeys(password);
		submitbtton.click();
	}
}

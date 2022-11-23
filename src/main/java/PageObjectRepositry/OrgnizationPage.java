package PageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgnizationPage {
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement CreateOrganizationbuton;
	
	public OrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreateOrganizationbuton() {
		return CreateOrganizationbuton;
	}

}

package PageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.genriclibrary.WebDriverUtility;

public class CreateOrgnizationPage extends WebDriverUtility {
	@FindBy(name  = "accountname")
	private WebElement OrganizationNamebox; 
	
	@FindBy(name  = "website")
	private WebElement websitebox;
	
	@FindBy(id = "tickersymbol")
	private WebElement tickersymbolbox;
	
	@FindBy(id = "employees")
	private WebElement employeesbox;
	
	@FindBy(id = "email2")
	private WebElement email2box;
	
	@FindBy(id = "phone")
	private WebElement phonebox ;
	
	@FindBy(id = "email1")
	private WebElement email1box ;
	
	@FindBy(name  = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath  = "//input[@title='Save [Alt+S]']")
	private WebElement Savebtn;
	
	public CreateOrgnizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationNamebox() {
		return OrganizationNamebox;
	}

	public WebElement getWebsitebox() {
		return websitebox;
	}

	public WebElement getTickersymbolbox() {
		return tickersymbolbox;
	}

	public WebElement getEmployeesbox() {
		return employeesbox;
	}

	public WebElement getEmail2box() {
		return email2box;
	}

	public WebElement getPhonebox() {
		return phonebox;
	}

	public WebElement getEmail1box() {
		return email1box;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}

	public void SetCreateOrgnization(String OrganizationName)
	{
		OrganizationNamebox.sendKeys(OrganizationName);
		Savebtn.click();
	}
	public void SetCreateOrgnization(String OrganizationName ,String IndustryValue)
	{
		OrganizationNamebox.sendKeys(OrganizationName);
		select(IndustryValue,industryDropDown);
	
		Savebtn.click();
	}
	
	public void SetCreateOrgnization(String OrganizationName,String IndustryValue,String TypeValue)
	{
		OrganizationNamebox.sendKeys(OrganizationName);
		select(IndustryValue,industryDropDown);
		select(TypeValue, typeDropDown);
		Savebtn.click();
	}
	

}

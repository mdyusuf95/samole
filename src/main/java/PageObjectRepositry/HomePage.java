package PageObjectRepositry;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Organizations")
	private WebElement Orgnization;
	
	@FindBy(linkText = "Calendar")
	private WebElement Calendar;
	
	@FindBy(linkText = "Leads")
	private WebElement Leads;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contacts;
	
	@FindBy(linkText = "Opportunities")
	private WebElement Opportunities;
	
	@FindBy(linkText = "Products")
	private WebElement Products;
	
	@FindBy(linkText = "Documents")
	private WebElement Documents;
	
	@FindBy(linkText = "Email")
	private WebElement Email;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroubleTickets;
	
	@FindBy(linkText = "Dashboard")
	private WebElement Dashboard;
	
	@FindBy(className = "tabUnSelected")
	private WebElement More;
	
	
	
	public HomePage(WebDriver driver )
	{
		PageFactory.initElements(driver, this);
	}



	public WebElement getOrgnization() {
		return Orgnization;
	}



	public WebElement getCalendar() {
		return Calendar;
	}



	public WebElement getLeads() {
		return Leads;
	}



	public WebElement getContacts() {
		return Contacts;
	}



	public WebElement getOpportunities() {
		return Opportunities;
	}



	public WebElement getProducts() {
		return Products;
	}



	public WebElement getDocuments() {
		return Documents;
	}



	public WebElement getEmail() {
		return Email;
	}



	public WebElement getTroubleTickets() {
		return TroubleTickets;
	}



	public WebElement getDashboard() {
		return Dashboard;
	}



	public WebElement getMore() {
		return More;
	}
	
	
	
		
		

}

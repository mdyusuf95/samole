package com.vtiger.genriclibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import PageObjectRepositry.CreateOrgnizationPage;
import PageObjectRepositry.HomePage;
import PageObjectRepositry.LogInPage;
import PageObjectRepositry.OrgnizationPage;


public class Base {
	public WebDriver driver ;
	public static WebDriver sdriver;
	
	static {System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");}
	static {System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");}
	static {System.setProperty("webdriver.edge.driver","./src/main/resources/msedgedriver.exe");}
	public ExcelUtility eLib =new ExcelUtility();
	public FileUtility  fLib =new FileUtility();
	public WebDriverUtility wLib= new WebDriverUtility(); 
	public JavaUtility jLib = new JavaUtility();
	public LogInPage lg;
	public HomePage HomePage;
	public OrgnizationPage orgnizationPage;
	public CreateOrgnizationPage co;

	@BeforeSuite
	public void connectDB()
	{
		System.out.println("------db connected----------");
	}
		
	//    @Parameters("browser")
		@BeforeClass(groups = {"smoke,regression"})
		public void openBroswer(/*String browser*/ ) throws IOException
		{   
	       String  Browser=fLib.readDatafromPropertyFile("Browser");
			if(Browser.equalsIgnoreCase("chrome"))
			{driver=new ChromeDriver();}
			else if(Browser.equalsIgnoreCase("firefox"))
			{driver=new FirefoxDriver();}
			else if(Browser.equalsIgnoreCase("edge"))
			{driver=new EdgeDriver();}
			else {Reporter.log ("invalid browser");}
			sdriver=driver;
			wLib.implicityWaitUntilPageLoad(driver, 20);
			String url = fLib.readDatafromPropertyFile("url");
			driver.get(url);
			
			
		}
          @BeforeMethod
          public void Login() throws IOException
          {
        	String username=fLib.readDatafromPropertyFile("username");
      		String password=fLib.readDatafromPropertyFile("password");
      		lg=new LogInPage(driver);
            lg.SetLogIn(username, password);
        	  
          }
		
		@AfterClass(groups = {"smoke,regression"})
		public void CloseBroswer() throws IOException
		{
			driver.quit();
				
		}
}

package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginMultipleData {
	WebDriver driver;
	String url ="http://orangehrm.qedgetech.com/";
	@Given("^user launch url \"([^\"]*)\"$")
	public void user_launch_url(String brw) throws Throwable {
	if(brw.equalsIgnoreCase("chrome"))
	{
		System.out.println("Executing on chrome Browser");
	 driver=new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 Thread.sleep(3000);
	}
	else if(brw.equalsIgnoreCase("firefox"))
	{
		System.out.println("Executing on firefox Browser");
	driver= new FirefoxDriver();
	driver.get(url);
	Thread.sleep(3000);
	}
	else
	{
		System.out.println("Browser value is not matching");
	}
	}

	@When("^user enter valid \"([^\"]*)\"$")
	public void user_enter_valid(String username) throws Throwable {
	 driver.findElement(By.name("txtUsername")).sendKeys(username);
	}

	@When("^user enter valid Pass \"([^\"]*)\"$")
	public void user_enter_valid_Pass(String password) throws Throwable {
	    driver.findElement(By.name("txtPassword")).sendKeys(password);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    driver.findElement(By.name("Submit")).click();
	}

	@Then("^user verify text in url$")
	public void user_verify_text_in_url() throws Throwable {
		String Expected ="dashboard";
	    String Actual = driver.getCurrentUrl();
	    if(Actual.contains(Expected))
	    {
	    	System.out.println("Login success::"+Expected+"   "+Actual);
	    }
	    else
	    {
	    	String message =driver.findElement(By.id("spanMessage")).getText();
	    	System.out.println(message+"     "+Expected+"   "+Actual);
	    }
	}

	@Then("^user verify close Browser$")
	public void user_verify_close_Browser() throws Throwable {
	    driver.close();
	}



}

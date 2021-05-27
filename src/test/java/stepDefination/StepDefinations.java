package stepDefination;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	import cucumber.api.java.en.Given;
	import cucumber.api.java.en.Then;
	import cucumber.api.java.en.When;

	public class StepDefinations {
		WebDriver driver;
		@Given("^I want to lauch url in a browser$")
		public void i_want_to_lauch_url_in_a_browser() throws Throwable {
		   driver = new ChromeDriver();
		   driver.manage().window().maximize();
		   driver.get("http://orangehrm.qedgetech.com/");
		   Thread.sleep(5000);
		}

		@When("^I enter valid username$")
		public void i_enter_valid_username() throws Throwable {
		    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		}

		@When("^I enter valid password$")
		public void i_enter_valid_password() throws Throwable {
			driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		}

		@When("^I Click on login button$")
		public void i_Click_on_login_button() throws Throwable {
			driver.findElement(By.name("Submit")).click();
			Thread.sleep(5000);
		}

		@Then("^Verify text in Url$")
		public void verify_text_in_Url() throws Throwable {
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

		@Then("^I close Browser$")
		public void i_close_Browser() throws Throwable {
		    driver.close();
		}

	}

	
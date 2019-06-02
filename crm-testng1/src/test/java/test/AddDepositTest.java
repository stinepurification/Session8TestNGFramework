package test;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddDepositPage;
import page.DashboradPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddDepositTest {

	@Test
	
	public void AddDepositToVeryfyDepositPosted() throws InterruptedException {
		// Starts the browser and saves the driver in the test class
		WebDriver driver = BrowserFactory.startBrowser();
		// Take you to the site
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// Calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// calling the method inside LoginPage
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		// Activate the DashboardPage
		DashboradPage dashboardPage = PageFactory.initElements(driver, DashboradPage.class);
		// call methods inside Dashboard Page
		dashboardPage.waitForPage();
		// Step: click on the add deposit button
		dashboardPage.clickOnAddDepositButton();
		// Activate Add Deposit Page
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);
		// validate Add Deposit Page open (waitforpage)
		addDepositPage.waitForPage();
		// A method to select a specific information from dropDown
		addDepositPage.selectFromDropDownForAccount("AutoAccount");
		addDepositPage.ClearTheDateAndInput("2019-06-12");
		addDepositPage.clickAway();
		Thread.sleep(500);
		// Initiate Random Class
		Random random = new Random();
		// Storage for description and Amount/String.valueof takes data as integer and
		// spit out String
		String expectedDescription = "TestDescription" + String.valueOf(random.nextInt(999));
		String expectedAmount = String.valueOf(random.nextInt(99999));
		// Method to input description and amount
		addDepositPage.inputDescriptionAndAmount(expectedDescription, expectedAmount);
		// click on SubmitButton
		addDepositPage.clickOnSubmitButton();
		// Explicit wait validation
		addDepositPage.waitForSuccessMsg();
		// Assertion class to validate
		//Assert.assertTrue("Success Message did not show!", addDepositPage.isSuccessMsgDisplayed());

		// Call the fill in the form method
		// String description = "Lunch Money";
		// addDepositPage.fillInTheAddDepositForm(description, "50");
//		driver.close();
//		 driver.quit();
	}
}
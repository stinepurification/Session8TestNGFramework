package test;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import junit.framework.Assert;
import page.AddExpensePage;
import page.DashboradPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddExpenseTest {
	
	@Test
	public void AddExpenseToVerifyExpensePosted() {
		WebDriver driver = BrowserFactory.startBrowser();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		DashboradPage dashboardPage = PageFactory.initElements(driver, DashboradPage.class);
		dashboardPage.waitForPage();
		Assert.assertTrue("DashboardPageTitle Displayed", dashboardPage.isDashBoardPageTitleDisplayed());
		dashboardPage.clickOnExpenseButton();
		AddExpensePage addExpensePage = PageFactory.initElements(driver, AddExpensePage.class);
		addExpensePage.waitForAddExpensePage();
		addExpensePage.selectFromDropDownForAccount("Tedla");
		addExpensePage.clearTheDateAndInputField("2019-05-31");
		addExpensePage.clickAway();
		Random random = new Random();
		String eDescription = "Zumba Classess" + String.valueOf(random.nextInt(125));
		String eAmount = String.valueOf(random.nextInt(1000));
		addExpensePage.inputDescriptionAndAmountField(eDescription, eAmount);
		addExpensePage.clickOnSubmitButton();
		addExpensePage.waitForExpenseAddedSuccessMsg();
		Assert.assertTrue("Success Message Not Posted", addExpensePage.isExpenseSuccessMsgDisplayed());
		driver.close();
		driver.quit();
	}

}

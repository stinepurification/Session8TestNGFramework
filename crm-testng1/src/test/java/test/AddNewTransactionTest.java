package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddNewTransaction;
import page.LoginPage;
import page.VerifyLogin;
import util.BrowserFactory;

public class AddNewTransactionTest {
	
	@Test

	public void navigateToTransaction() throws InterruptedException {
		WebDriver driver = BrowserFactory.startBrowser();
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		VerifyLogin verifyLogin = PageFactory.initElements(driver, VerifyLogin.class);
		verifyLogin.LoginVerify();
		AddNewTransaction addNewTransaction = PageFactory.initElements(driver, AddNewTransaction.class);
		addNewTransaction.navigateToTransaction();
		addNewTransaction.makeNewTransaction();
		addNewTransaction.verifyTransaction();
		//Adding comment to make a change in file in order to re commit
	}
}
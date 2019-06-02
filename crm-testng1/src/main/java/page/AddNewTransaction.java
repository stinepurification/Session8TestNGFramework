package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddNewTransaction {
	WebDriver driver;

	public AddNewTransaction(WebDriver driver) {
		this.driver = driver;
	}

	// Element Library
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")WebElement DashboardText;
	@FindBy(how = How.XPATH, using = "//span[@class='nav-label' and contains(text(),'Transactions')]")WebElement Transaction;
	@FindBy(how = How.LINK_TEXT, using = "New Deposit")WebElement AddDeposit;
	@FindBy(how = How.XPATH, using = "//select[@id='account']/option[@value='Rajib']")WebElement SelectAccount;
	@FindBy(how = How.XPATH, using = "//input[@id='date']")WebElement SetDate;
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Description')]")WebElement LabelDescription;
	@FindBy(how = How.XPATH, using = "//input[@id='description']")WebElement DescriptionField;
	@FindBy(how = How.XPATH, using = "//input[@id='amount']")WebElement AmountField;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")WebElement SubmitButton;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Bonus')]")WebElement DesVerification;
	@FindBy(how = How.XPATH, using = "//td[@class='amount' and contains(text(),'$ 500.00')]")WebElement AmountVerification;

	public void navigateToTransaction() {
		Transaction.click();
		AddDeposit.click();
	}

	public void makeNewTransaction() {
		SelectAccount.click();
		SetDate.clear();
		SetDate.sendKeys("2019-06-01");
		LabelDescription.click();
		DescriptionField.sendKeys("Bonus");
		AmountField.sendKeys("500");
		SubmitButton.click();
	}

	public void verifyTransaction() throws InterruptedException {
		Thread.sleep(5000);
		String DesValue = DesVerification.getText();
		String AmountValue = AmountVerification.getText();
		assert (DesVerification.isDisplayed());
		System.out.println("Description: " + DesValue);
		assert (DesVerification.isDisplayed());
		System.out.println("Description: " + AmountValue);
		//Closing Browser
		driver.close();
		driver.quit();
	}
}

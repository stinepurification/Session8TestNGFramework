package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class AddExpensePage extends BasePage {

	WebDriver driver;

	public AddExpensePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//h5[text() = 'Add Expense']")
	WebElement AddExpensePanelHeading;
	@FindBy(how = How.XPATH, using = "//select[@id='account']")
	WebElement AccountDropDown;
	@FindBy(how = How.ID, using = "date")
	WebElement DateField;
	@FindBy(how = How.ID, using = "description")
	WebElement DescriptionField;
	@FindBy(how = How.ID, using = "amount")
	WebElement AmountField;
	@FindBy(how = How.ID, using = "submit")
	WebElement ClickOnSubmitButton;
	@FindBy(how = How.XPATH, using = "//div[@class='alert alert-success fade in']")
	WebElement ExpenseAddedMsg;

	public void selectFromDropDownForAccount(String names) {
		Select select = new Select(AccountDropDown);
		select.selectByVisibleText(names);
	}

	public void waitForAddExpensePage() {
		waitForElement(AddExpensePanelHeading, driver);
	}

	public void clearTheDateAndInputField(String date) {
		DateField.clear();
		DateField.sendKeys(date);
	}

	public void clickAway() {
		AddExpensePanelHeading.click();
	}

	public void inputDescriptionAndAmountField(String eDescription, String eAmount) {
		DescriptionField.sendKeys(eDescription);
		AmountField.sendKeys(eAmount);
	}

	public void clickOnSubmitButton() {
		ClickOnSubmitButton.click();
	}

	public void waitForExpenseAddedSuccessMsg() {
		waitForElement(ExpenseAddedMsg, driver);
	}

	public boolean isExpenseSuccessMsgDisplayed() {
		try {
			return ExpenseAddedMsg.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}

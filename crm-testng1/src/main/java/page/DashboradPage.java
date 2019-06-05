package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboradPage extends BasePage {
	WebDriver driver;

	public DashboradPage(WebDriver driver) {

		this.driver = driver;

	}

//Element Library or repository
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit")
	WebElement AddDepositButton;
	@FindBy(how = How.LINK_TEXT, using = "Add Expense")
	WebElement AddExpenseButton;

	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}

	public void clickOnAddDepositButton() {
		AddDepositButton.click();
	}

	public void clickOnExpenseButton() {
		AddExpenseButton.click();
	}

	public void waitForDashBoardPage() {
		waitForElement(PageTitle, driver);

	}

	public boolean isDashBoardPageTitleDisplayed() {
		return PageTitle.isDisplayed();
	}

}

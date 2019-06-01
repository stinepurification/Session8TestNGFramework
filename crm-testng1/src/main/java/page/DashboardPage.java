package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	@FindBy(how = How.XPATH, using = "//h2[text()='Dashboard ']")
	WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit")
	WebElement AddDepositButton;

	public void clickOnAddDepositButton() {
		AddDepositButton.click();
	}
}
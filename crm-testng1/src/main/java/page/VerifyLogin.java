package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class VerifyLogin {
	WebDriver driver;

	public VerifyLogin(WebDriver driver) {
		this.driver = driver;
	}	
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement DashboardText;

	public void LoginVerify() throws InterruptedException {
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		assert(DashboardText.isDisplayed());
		System.out.println("Dashboard Login Successfull");
	}
}

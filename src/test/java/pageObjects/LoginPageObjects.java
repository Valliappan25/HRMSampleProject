package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	private WebDriver driver;

	@FindBy(name="txtUsername")
	private WebElement loginUserName;
	
	@FindBy(name="txtPassword")
	private WebElement loginPassword;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	public LoginPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login(String username, String password)
	{
		loginUserName.sendKeys(username);
		loginPassword.sendKeys(password);
		loginButton.click();
	}
}

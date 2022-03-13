package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserRolePageObjects {

	private WebDriver driver;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminLink;
	
	@FindBy(id = "menu_admin_UserManagement")
	private WebElement userManagemenLink;
	
	@FindBy(id = "menu_admin_viewSystemUsers")
	private WebElement viewUsersLink;
	
	@FindBy(id = "searchSystemUser_userName")
	private WebElement systemUserName;
	
	@FindBy(id = "searchSystemUser_userType")
	private WebElement systemUserRole;
	
	@FindBy(id = "searchSystemUser_status")
	private WebElement systemUserStatus;
	
	@FindBy(id = "searchBtn")
	private WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]//tr//td[3]")
	private WebElement userRoleValue;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]//tr//td[5]")
	private WebElement userStatusValue;
	
	public UserRolePageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateUserLink() throws InterruptedException
	{
		Actions actions = new Actions(driver);
		
		actions.moveToElement(adminLink);
		//Thread.sleep(3000);
		actions.moveToElement(userManagemenLink);
		//Thread.sleep(3000);
		actions.moveToElement(viewUsersLink);
		actions.click().build().perform();
		
	}
	
	public void getuserDetails(String username, String role, String status)
	{
		systemUserName.sendKeys(username);
		Select roleSelect = new Select(systemUserRole);
		roleSelect.selectByVisibleText(role);
		
		Select statusSelect = new Select(systemUserStatus);
		statusSelect.selectByVisibleText(status);
		
		searchButton.click();		
	}
	
	public String validateUserRole()
	{
		String userRole = userRoleValue.getText();
		
		return userRole;
	}
	
	public String validateUserstatus()
	{
		String userStatus = userStatusValue.getText();
		
		return userStatus;
	}
	
}

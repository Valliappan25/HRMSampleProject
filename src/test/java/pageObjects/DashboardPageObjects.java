package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObjects  {
	
	private WebDriver driver;

	@FindBy(xpath="//*[@id=\"task-list-group-panel-menu_holder\"]//tr")
	private List<WebElement> pendingLeaveRequest;
	
	public DashboardPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void displayPendingLeaveRequest() {
		
		for(WebElement element : pendingLeaveRequest)
		{
			System.out.println(element.getText());
		}
	}
	
}

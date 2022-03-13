package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import junit.framework.Assert;
import pageObjects.DashboardPageObjects;
import pageObjects.LoginPageObjects;

public class TestCase_PendingLeaveRequest extends CommonFunctions {

	static Logger logger = Logger.getLogger(TestCase_PendingLeaveRequest.class);

	public static void applicationLogin()
	{
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		LoginPageObjects loginPage = new LoginPageObjects(driver);
		logger.info("Logging in to the OrangeHRM Application");
		loginPage.login(username,password);
	}
	
	@Test
	public void verifyPendingLeaveRequest()
	{
		applicationLogin();
		
		DashboardPageObjects dashboardPage = new DashboardPageObjects(driver);
		logger.info("Login Successful");
		logger.info("Listing all Pending Leave Request");
		dashboardPage.displayPendingLeaveRequest(); 
		logger.info("Ending of TestCase_PendingLeaveRequest Execution");
		//Assert.assertEquals(actualMessage, "No Records are Available");
	}
}

package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import commonFunctions.CommonFunctions;
import junit.framework.Assert;
import pageObjects.UserRolePageObjects;

public class Testcase_UserRole extends CommonFunctions {
	static Logger logger = Logger.getLogger(Testcase_UserRole.class);

	@Test
	public void searchAndValidateUser() throws InterruptedException
	{
		//TestCase_PendingLeaveRequest.applicationLogin();
		UserRolePageObjects userRolePage = new UserRolePageObjects(driver);
		
		logger.info("Navigate to User search page");
		userRolePage.navigateUserLink();
		
		logger.info("Search user by entering Username, role and status");
		userRolePage.getuserDetails("Admin", "Admin", "Enabled");
		
		String role = userRolePage.validateUserRole();
		logger.info("Validate the user details by role");
		Assert.assertEquals(role, "Admin");
		logger.info("Validation successful!! Role matched");
		
		logger.info("Validate the user details by status");
		String status = userRolePage.validateUserstatus();
		Assert.assertEquals(status, "Enabled");
		logger.info("Validation successful!! status matched");
		logger.info("End of Testcase_UserRole Execution");
	}
	
	
}

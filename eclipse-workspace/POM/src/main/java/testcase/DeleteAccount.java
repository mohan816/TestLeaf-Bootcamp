package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class DeleteAccount extends BaseClass {
	@BeforeClass
	public void setFileName() {
		fileName="EditAccounts";
	}
	@Test(dataProvider="fetchData")
	public void deleteAccount(String username, String Password) throws InterruptedException {
		new LoginPage(driver,prop).enterUsername(username).enterPassword(Password).clickLogin().clickLightningExperiene().navigateHomePage().clickAppLauncher().
		clickViewAll().clickAccounts().searchTextBox().clickDropListAccountName().clickDelete();
	}

}

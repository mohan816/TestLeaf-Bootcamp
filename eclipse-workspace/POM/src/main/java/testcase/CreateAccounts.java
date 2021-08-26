package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateAccounts extends BaseClass {

	@BeforeClass
	public void setFileName() {
		fileName="Accounts";
	}
	@Test(dataProvider="fetchData")
	public void createAccounts(String username, String password, String name) {
		LoginPage obj=new LoginPage(driver);
		obj.enterUsername(username).enterPassword(password).clickLogin().clickLightningExperiene().navigateHomePage().clickAppLauncher().clickViewAll().clickAccounts().clickNew().enterAccountName().selectOwnership().clickSave().clickDetails().verifyAccountName(name);
		

}
}

package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CzEditAccounts extends BaseClass{
	@BeforeClass
	public void setFileName() {
		fileName="EditAccounts";
	}
	@Test(dataProvider="fetchData")
	public void createAccounts(String username, String password) throws InterruptedException {
		new LoginPage(driver).enterUsername(username).enterPassword(password).clickLogin().clickLightningExperiene().navigateHomePage().clickAppLauncher().clickViewAll()
		.clickAccounts().clickDropListAccountName().clickEdit().selectTypeDroplist().selectTechnologydroplist()
		.enterBillingStreet().enterShippingStreet().selectCustomerPriority().selectSLA().selectActive().enterPhone()
		.clickSave().clickAccountName().clickDetails().verifyPhoneNumber();

}}

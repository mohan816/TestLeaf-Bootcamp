package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class CreateOpportunity extends BaseClass{
@BeforeClass
public void setFileName() {
	fileName="createOpportunity";
}
@Test(dataProvider="fetchData")
	public void createOpportunity(String username, String password, String textbox, String date) throws InterruptedException {
	new LoginPage(driver).enterUsername(username).enterPassword(password).clickLogin().clickLightningExperiene().navigateHomePage().clickAppLauncher().
	clickViewAll().clickSales().clickOpportunities().clickNew().enterOpportunityName(textbox).selectNeedAnalysisInStage().
	sendValueToCLoseDate(date).clickSave().verifySuccessMessage(textbox);
		
	}
}
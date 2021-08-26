package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class EditOpportunity extends BaseClass {
	@BeforeClass
	public void setFileName() {
		fileName="EditOpportunity";
	}
	@Test(dataProvider="fetchData")
	public void EditOpportunity(String username, String Password, String textbox, String dropList, String date) throws InterruptedException {
		new LoginPage(driver).enterUsername(username).enterPassword(Password).clickLogin().clickLightningExperiene().navigateHomePage().clickAppLauncher().clickViewAll().clickSales().clickOpportunities().
		enterValueInSerachTextBox(textbox).clickEdit().clickStage().enterCloseDate(date).enterDescription().clickSave().clickOpportunityName(textbox)
		.clickDetails().verifyOpportunityIsEdited(dropList);
		
	}

}

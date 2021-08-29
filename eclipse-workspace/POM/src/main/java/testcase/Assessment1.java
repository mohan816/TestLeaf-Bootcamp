package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class Assessment1 extends BaseClass{
	@BeforeClass
	public void setFileName() {
		fileName="Assessment";
	}
	@Test(dataProvider="fetchData")
	public void createAssessment(String Subject, String username, String password) {
		new LoginPage(driver,prop).enterUsername(username).enterPassword(password).clickLogin().clickLightningExperiene().navigateHomePage()
		.clickCommunity().getAppAndDeveloperName().clickViewProfile().clickSwitchToSalesforceClassic().clickCreateNew().clickEvent()
		.enterName(Subject).enetrStart().enterEnd().clickLookUp().enterValueInSearch().clickSearchResults().clickAttachFile()
		.selectFile().clickAttachFileButton().clickDone().getAttachmentText().verifyFileName().clickSave();
		
	}

}

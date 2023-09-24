package Organisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.organisation.CreateNewOrganisationPage;
import object.repository.organisation.OrganisationInfoPage;
import object.repository.organisation.OrganisationPage;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		return eutil.readMultipleDateFromExcelSheet("DataProviderOrg");
	}

	@Test(dataProvider = "getData")
	public void createMultipleOrgWithIndustryTest(String ORGNAME, String INDUSTRY) {

		int r = jutil.getRandomNumber();

		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationsLinkText();

		OrganisationPage op = new OrganisationPage(d);
		op.clickOnCreateOrganizationsLookUpImg();

		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(d);
		cnop.createOrgWithIndustry(d, ORGNAME + r, INDUSTRY);

		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgHeaderText = oip.getOrgHeaderText();
		Assert.assertTrue(orgHeaderText.contains(ORGNAME));

	}
}

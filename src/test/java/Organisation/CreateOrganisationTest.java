package Organisation;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.organisation.CreateNewOrganisationPage;
import object.repository.organisation.OrganisationInfoPage;
import object.repository.organisation.OrganisationPage;

public class CreateOrganisationTest extends BaseClass {

	@Test(groups = { "SmokeSuite", "RegressionSuite" }, priority = 1, invocationCount = 3, enabled = true)
	public void createOrgTest() throws EncryptedDocumentException, IOException {

		int r = jutil.getRandomNumber();

		String ORGNAME = eutil.readDataFromExcelSheet("Organisation", 4, 2) + r;
		String INDUSTRYNAME = eutil.readDataFromExcelSheet("Organisation", 4, 3);

		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationsLinkText();

		OrganisationPage op = new OrganisationPage(d);
		op.clickOnCreateOrganizationsLookUpImg();

		CreateNewOrganisationPage cnop = new CreateNewOrganisationPage(d);
		cnop.createOrgWithIndustry(d, ORGNAME, INDUSTRYNAME);

		OrganisationInfoPage oip = new OrganisationInfoPage(d);
		String orgHeaderText = oip.getOrgHeaderText();
		Assert.assertTrue(orgHeaderText.contains(ORGNAME));
	}
}

package Organisation;

import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.organisation.OrganisationPage;

public class DeleteAllOrganisationTest extends BaseClass {

	@Test
	public void deleteAllOrgTest() throws InterruptedException {

		HomePage hp = new HomePage(d);
		hp.clickOnOrganizationsLinkText();

		OrganisationPage op = new OrganisationPage(d);
		op.deleteAllOrgData(d);
	}

}

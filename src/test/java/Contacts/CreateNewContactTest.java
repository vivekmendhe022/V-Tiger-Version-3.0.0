package Contacts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.contacts.ContactsInfoPage;
import object.repository.contacts.ContactsPage;
import object.repository.contacts.CreateNewContactsPage;

public class CreateNewContactTest extends BaseClass {

	@Test(groups = { "SmokeSuite", "RegressionSuite" }, priority = 1, invocationCount = 3, enabled = true)
	public void createNewContactTest() throws EncryptedDocumentException, IOException {

		int r = jutil.getRandomNumber();

		String SalutationType = eutil.readDataFromExcelSheet("Contact", 4, 5);
		String FIRSTNAME = eutil.readDataFromExcelSheet("Contact", 4, 4);
		String LASTNAME = eutil.readDataFromExcelSheet("Contact", 4, 2) + " " + r;

		HomePage hp = new HomePage(d);
		hp.clickOnContactsLinkText();

		ContactsPage cp = new ContactsPage(d);
		cp.clickOnCreateNewContactsLookUpImg();

		CreateNewContactsPage cncp = new CreateNewContactsPage(d);
		cncp.createNewContacts(SalutationType, FIRSTNAME, LASTNAME);

		ContactsInfoPage cip = new ContactsInfoPage(d);
		String contactsHeaderText = cip.getContactsHeaderText();
		Assert.assertTrue(contactsHeaderText.contains(LASTNAME));
	}
}

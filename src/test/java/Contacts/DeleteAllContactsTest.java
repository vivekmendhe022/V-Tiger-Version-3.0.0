package Contacts;

import org.testng.annotations.Test;

import generic.utility.BaseClass;
import object.repository.HomePage;
import object.repository.contacts.ContactsPage;

public class DeleteAllContactsTest extends BaseClass {

	@Test
	public void deleteALlContactsTest() throws InterruptedException {
		HomePage hp = new HomePage(d);
		hp.clickOnContactsLinkText();

		ContactsPage cp = new ContactsPage(d);
		cp.deleteAllCotactsData(d);
	}
}

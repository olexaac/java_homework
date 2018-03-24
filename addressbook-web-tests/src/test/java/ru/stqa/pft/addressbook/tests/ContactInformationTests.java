package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Админ on 11.03.2018.
 */
public class ContactInformationTests extends TestBase{

  @Test
  public void testContactAddress() {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat(contact.getLname(), equalTo(contactInfoFromDetailsForm.getLname()));
  }

}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

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

    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromDetailsForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactInformationTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}

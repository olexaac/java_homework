package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Админ on 01.03.2018.
 */
public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().contactPage();
    if (app.contact().List().size() == 0) {
      app.contact().create(new ContactData().withFname("Test").withLname("Testov").withCity("Moscow").withPhone("+7(123)-456-78-90").withGroup("test1"), true);
    }
  }

  @Test
  public void testContactModification(){
    List<ContactData> before = app.contact().List();
    int index = before.size() - 1;
    ContactData contact = new ContactData()
            .setId(before.get(index).getId()).withFname("Test").withLname("Testov").withCity("Moscow").withPhone("+7(123)-456-78-90");
    app.contact().modify(index, contact);
    List<ContactData> after = app.contact().List();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}

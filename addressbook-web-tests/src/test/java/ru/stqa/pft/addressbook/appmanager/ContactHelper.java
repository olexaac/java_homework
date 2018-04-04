package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by Админ on 01.03.2018.
 */
public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFname());
    type(By.name("lastname"), contactData.getLname());
    //attach(By.name("photo"), contactData.getPhoto());
    type(By.name("address"), contactData.getCity());
    type(By.name("mobile"), contactData.getPhone());

    if (creation) {
      if (contactData.getGroup() != null) {
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      }
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteEditContacts() {
    click(By.xpath("//input[@name='update'][@value='Delete']"));
  }

  public void editContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']",id))).click();
  }

  public void detailsContactById(int id) {
    wd.findElement(By.cssSelector(String.format("a[href='view.php?id=%s']",id))).click();
  }

  public void submitContactModification() {
    click(By.xpath("//input[@name='update'][@value='Update']"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm((contact), b);
    submitContactCreation();
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    editContactById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    editContactById(contact.getId());
    deleteEditContacts();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//a[contains(@href,'edit.php?')]"));
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("//a[contains(@href,'edit.php?')]")).size();
  }

  public Contacts all() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allAddress = cells.get(3).getText();
      String allEMails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contacts.add(new ContactData().withId(id).withFname(firstname).withLname(lastname)
              .withAllEmails(allEMails)
              .withAllAddress(allAddress)
              .withAllPhones(allPhones));
    }
    return contacts;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    editContactById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFname(firstname).withLname(lastname)
            .withEmail(email).withEmail2(email2).withEmail3(email3)
            .withAllAddress(address)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
  }

  public ContactData infoFromDetailsForm(ContactData contact) {
    detailsContactById(contact.getId());
    String home = wd.findElement(By.xpath("//div[@id='content']")).getText();
    //String mobile = wd.findElement(By.xpath("//div[@id='content']/br[4]")).getText();
    //String work = wd.findElement(By.xpath("//div[@id='content']/br[5]")).getText();
    wd.navigate().back();
    return new ContactData().withId(contact.getId())
            .withHomePhone(home);
            //.withMobilePhone(mobile).withWorkPhone(work);
  }
}

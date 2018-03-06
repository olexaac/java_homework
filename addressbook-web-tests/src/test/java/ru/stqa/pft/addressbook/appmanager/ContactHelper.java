package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
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
    type(By.name("address"), contactData.getCity());
    type(By.name("mobile"), contactData.getPhone());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
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

  public void editContact(int index) {
    wd.findElements((By.xpath("//a[contains(@href,'edit.php?')]"))).get(index).click();
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

  public void modify(int index, ContactData contact) {
    editContact(index);
    fillContactForm(contact, false);
    submitContactModification();
    returnToContactPage();
  }

  public void delete(int index) {
    editContact(index);
    deleteEditContacts();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//a[contains(@href,'edit.php?')]"));
  }

  public int getContactCount() {
    return wd.findElements(By.xpath("//a[contains(@href,'edit.php?')]")).size();
  }

  public List<ContactData> List() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstnane = cells.get(2).getText();
      ContactData contact = new ContactData(id, firstnane, lastname, null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}

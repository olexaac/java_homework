package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

/**
 * Created by Админ on 01.03.2018.
 */
public class ContactHelper extends HelperBase {
  private FirefoxDriver wd;

  public ContactHelper(FirefoxDriver wd) {
    super(wd);
  }

  public void returnToContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFname());
    type(By.name("lastname"), contactData.getLname());
    click(By.name("address"));
    type(By.name("address"), contactData.getCity());
    click(By.name("mobile"));
    type(By.name("mobile"), contactData.getPhone());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteEditContacts() {
    click(By.xpath("//input[@name='update'][@value='Delete']"));
  }

  public void editContact() {
    click(By.xpath("//a[contains(@href,'edit.php?')]"));
  }
}

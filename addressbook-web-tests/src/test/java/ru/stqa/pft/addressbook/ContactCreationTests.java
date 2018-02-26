package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

  @Test
  public void testContactCreation() {
    gotoContactPage();
    initContactPage();
    fillContactForm(new ContactData("Test", "Testov", "Moscow", "+7(123)-456-78-90"));
    submitContactCreation();
    returnToContactPage();
  }

  private void returnToContactPage() {
    wd.findElement(By.linkText("home page")).click();
  }

  private void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(ContactData contactData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactData.getFname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactData.getLname());
    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactData.getPhone());
  }

  private void gotoContactPage() {
    wd.findElement(By.linkText("home")).click();
  }

  private void initContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }
}

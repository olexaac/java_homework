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

}

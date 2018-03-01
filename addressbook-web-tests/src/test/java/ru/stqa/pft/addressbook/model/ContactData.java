package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String fname;
  private final String lname;
  private final String city;
  private final String phone;

  public ContactData(String fname, String lname, String city, String phone) {
    this.fname = fname;
    this.lname = lname;
    this.city = city;
    this.phone = phone;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public String getCity() {
    return city;
  }

  public String getPhone() {
    return phone;
  }
}

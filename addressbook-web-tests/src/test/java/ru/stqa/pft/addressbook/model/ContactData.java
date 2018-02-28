package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String fname;
  private final String lname;
  private final String address;
  private final String phone;

  public ContactData(String fname, String lname, String address, String phone) {
    this.fname = fname;
    this.lname = lname;
    this.address = address;
    this.phone = phone;
  }

  public String getFname() {
    return fname;
  }

  public String getLname() {
    return lname;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }
}

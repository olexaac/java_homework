package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final int id;
  private final String fname;
  private final String lname;
  private final String city;
  private final String phone;
  private String group;

  public ContactData(int id, String fname, String lname, String city, String phone, String group) {
    this.id = id;
    this.fname = fname;
    this.lname = lname;
    this.city = city;
    this.phone = phone;
    this.group = group;
  }

  public ContactData(String fname, String lname, String city, String phone, String group) {
    this.id = Integer.parseInt(null);
    this.fname = fname;
    this.lname = lname;
    this.city = city;
    this.phone = phone;
    this.group = group;
  }

  public int getId() {
    return id;
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

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (id != that.id) return false;
    if (fname != null ? !fname.equals(that.fname) : that.fname != null) return false;
    return lname != null ? lname.equals(that.lname) : that.lname == null;

  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (fname != null ? fname.hashCode() : 0);
    result = 31 * result + (lname != null ? lname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", fname='" + fname + '\'' +
            ", lname='" + lname + '\'' +
            '}';
  }

}

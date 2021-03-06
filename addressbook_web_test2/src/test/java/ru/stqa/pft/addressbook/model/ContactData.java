package ru.stqa.pft.addressbook.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.appmanager.HelperBase;

public class ContactData {
    private final String name;
    private final String middlename;
    private final String surname;
   // private final String nick;
   // private final String company;
   // private final String city;
   // private final String phone;
   // private final String email;
   // private final String bday;
   // private final String bmonth;
   // private final String byear;
   // private final String city2;
   // private final String test1;
   // private final String phone2;
   // private final String notes;
    private String group;

    public ContactData(String name, String middlename, String surname, String group) {
        this.name = name;
        this.middlename = middlename;
        this.surname = surname;
       // this.nick = nick;
       // this.company = company;
      // this.city = city;
       // this.phone = phone;
      //  this.email = email;
      //  this.bday = bday;
      //  this.bmonth = bmonth;
      //  this.byear = byear;
      //  this.city2 = city2;
      //  this.test1 = test1;
      //  this.phone2 = phone2;
      //  this.notes = notes;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSurname() {
        return surname;
    }

   /* public String getNick() {
        return nick;
    }

    public String getCompany() {
        return company;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBday() {
        return bday;
    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getCity2() {
        return city2;
    }

    public String getTest1() {
        return test1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    } */

    public String getGroup() {
        return group;
    }

}

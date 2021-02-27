package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactAddNewEntry extends TestBase {


  @Test
  public void testAddEntryToCatalog() throws Exception {


    app.getContactHelper().AddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova", "Olga", "BBB", "Riga", "22233355", "lena-usc@inbox.lv", "28", "April", "1978", "Riga", "test1", "Riga", "catalog entry2"));
    app.getContactHelper().submitForm();
    app.getNavigationHelper().GoToHome();
    app.logout();
  }



}

package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

public class ContactCreationTests extends TestBase {


  @Test
  public void testAddEntryToCatalog() throws Exception {


    app.getContactHelper().AddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
   // app.getContactHelper().submitForm();
   //app.getNavigationHelper().GoToHome();
  // app.logout();
  }



}

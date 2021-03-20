package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testAddEntryToCatalog() throws Exception {

    app.getNavigationHelper().GoToHome();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().AddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
   // app.getContactHelper().submitForm();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);

    //app.getContactHelper().submitForm();
   //app.getNavigationHelper().GoToHome();
  // app.logout();
  }



}

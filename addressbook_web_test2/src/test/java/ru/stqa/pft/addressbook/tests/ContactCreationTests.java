package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testAddEntryToCatalog() throws Exception {

    app.getNavigationHelper().GoToHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().AddNewContact();
    app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
    app.getContactHelper().submitForm();
    app.getNavigationHelper().GoToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
   // int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    //app.getContactHelper().submitForm();
   //app.getNavigationHelper().GoToHome();
  // app.logout();
  }



}

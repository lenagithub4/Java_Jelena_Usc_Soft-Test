package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test
  public void testAddEntryToCatalog() throws Exception {

    app.getNavigationHelper().GoToHome();
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();
    app.getContactHelper().AddNewContact();
    ContactData entry = new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1");
    app.getContactHelper().createContact(entry,true);
   // app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
    //app.getContactHelper().submitForm();
    app.getNavigationHelper().GoToHome();
    List<ContactData> after = app.getContactHelper().getContactList();
   // int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size() + 1);


    //int max = 0;
   // for (ContactData q : after) {
   //   if (q.getId() > max) {
   //     max = q.getId();
    //  }
    //}
   // Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1 = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId();
    entry.setId(after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(entry);

    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    //app.getContactHelper().submitForm();
   //app.getNavigationHelper().GoToHome();
  // app.logout();
  }



}

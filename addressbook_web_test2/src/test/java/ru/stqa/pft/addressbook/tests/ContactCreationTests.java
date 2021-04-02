package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


  @Test(enabled=true)
  public void testAddEntryToCatalog() throws Exception {

    app.goTo().GoToHome();
    List<ContactData> before = app.contact().contactList();
    //int before = app.getContactHelper().getContactCount();
    app.contact().AddNewContact();
    ContactData entry = new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1");
    app.contact().createContact(entry,true);
   // app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
    //app.getContactHelper().submitForm();
    app.goTo().GoToHome();
    List<ContactData> after = app.contact().contactList();
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
    Comparator<? super ContactData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    }



}

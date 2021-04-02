package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactCreationTests extends TestBase {


  @Test(enabled=true)
  public void testAddEntryToCatalog() throws Exception {

    app.goTo().GoToHome();
   Contacts before = app.contact().all();
    //int before = app.getContactHelper().getContactCount();
    app.contact().AddNewContact();
    ContactData entry = new ContactData().withName("Olga").withMiddlename("Vladimirovna").withSurname("Uscelemova").withGroup("test1");
    app.contact().createContact(entry,true);
   // app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Uscelemova",   "test1"), true);
    //app.getContactHelper().submitForm();
    app.goTo().GoToHome();
    Contacts after = app.contact().all();
   // int after = app.getContactHelper().getContactCount();
    assertEquals(after.size(), before.size() + 1);


    //int max = 0;
   // for (ContactData q : after) {
   //   if (q.getId() > max) {
   //     max = q.getId();
    //  }
    //}
   // Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1 = after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId();

    //entry.setId(after.stream().max( (o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
   // entry.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
   // before.add(entry);
    //Comparator<? super ContactData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
    //before.sort(byId);
    //after.sort(byId);
    //assertEquals(before, after);
    assertThat(after, equalTo(
            before.withAdded(entry.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt())))); /*proverjalka Hamcrest L.5.6 */

    }



}

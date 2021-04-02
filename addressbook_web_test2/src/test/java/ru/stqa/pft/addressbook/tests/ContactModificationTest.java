package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupForm;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase{

    public void ensurePreconditions() {
        app.goTo().GoToHome();

        if (!app.contact().isThereAContact()) {
            if (app.group().all().size() == 0) {
                app.group().create(new GroupForm().withName("test1"));
            }
            app.contact().createContact(new ContactData().withName("Name").withMiddlename("Name2").withSurname("Surname").withGroup("test1"), true);
        }
    }

    @Test(enabled=true)
    public void testContactModification() {
        //app.goTo().GoToHome();
        Contacts before = app.contact().all();
                  //int before = app.getContactHelper().getContactCount();
        ContactData modifiedContact = before.iterator().next();
        //int index = before.size() - 1;
        ContactData entry = new ContactData()
                .withId(modifiedContact.getId()).withName("Olga2").withMiddlename("Vladimirovna_modif").withSurname("Bubina_modif");   //I have deleted the group approve b: true/false
        //app.getContactHelper().fillContactForm(new ContactData("Olga2", "Vladimirovna_modif", "Bubina_modif", null), false); app.goTo().GoToHome();
        app.contact().modifyContract(entry);

        Contacts after = app.contact().all();
       // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size());

         // Lesson 4.7
        //before.remove(modifiedContact);
       //before.add(entry);
       // Comparator<? super ContactData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
       // before.sort(byId);
       // after.sort(byId);
       //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(entry))); /*proverjalka Hamcrest L.5.6 */
    }


}

package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteTest extends TestBase {

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
    public void testContactDelete() {
        app.goTo().GoToHome();
        Contacts before = app.contact().all();
        //int before = app.getContactHelper().getContactCount();
        ContactData deletedContact = before.iterator().next();
        //int index = before.size() - 1; /* L.5.5 */

        app.contact().delete(deletedContact);
        Contacts after = app.contact().all();
        // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() - 1);

        // lesson 4.7
       // before.remove(deletedContact); // back before list to preview state (for Variant 1, Variant 2)
        //for (int i = 0; i < after.size(); i++) { // no necessary Variant 1
        //    Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
        assertThat(after, equalTo(before.withOut(deletedContact))); /*proverjalka Hamcrest L.5.6 */
        //Assert.assertEquals(before, after);
        }


}


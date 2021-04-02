package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.List;

public class ContactDeleteTest extends TestBase {

    public void ensurePreconditions() {
        app.goTo().GoToHome();

        if (!app.contact().isThereAContact()) {
            if (app.group().all().size() == 0) {
                app.group().create(new GroupForm().withName("test1"));
            }
            app.contact().createContact(new ContactData("Name", "Name2", "Surname", "test1"), true);
        }
    }



    @Test(enabled=true)
    public void testContactDelete() {
        app.goTo().GoToHome();
        List<ContactData> before = app.contact().contactList();
        //int before = app.getContactHelper().getContactCount();
        int index = before.size() - 1;

        app.contact().delete(index);
        List<ContactData> after = app.contact().contactList();
        // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() - 1);

        // lesson 4.7
        before.remove(index); // back before list to preview state (for Variant 1, Variant 2)
        //for (int i = 0; i < after.size(); i++) { // no necessary Variant 1
        //    Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
        Assert.assertEquals(before, after);
        }


}


package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.List;

public class ContactDeleteTest extends TestBase {
    @Test(enabled=false)
    public void testContactDelete() {
        app.goTo().GoToHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        //int before = app.getContactHelper().getContactCount();

        if (!app.getContactHelper().isThereAContact()) {
            if (!app.group().isThereAGroup()) {
                app.group().create(new GroupForm().withName("test1"));
            }
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname", "test1"), true);
        }
        app.goTo().GoToHome();
        app.getContactHelper().selectContact(before.size() - 1);
        app.getContactHelper().selectContactEdit(before.size() - 1);
        app.getContactHelper().deleteContact();
        app.goTo().GoToHome();
        List<ContactData> after = app.getContactHelper().getContactList();
        // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() - 1);

        // lesson 4.7
        before.remove(before.size() - 1); // back before list to preview state (for Variant 1, Variant 2)
        //for (int i = 0; i < after.size(); i++) { // no necessary Variant 1
        //    Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
        Assert.assertEquals(before, after);
        }
    }


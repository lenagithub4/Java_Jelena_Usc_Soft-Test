package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

public class ContactDeleteTest extends TestBase {
    @Test
    public void testContactDelete() {
        app.getNavigationHelper().GoToHome();
        int before = app.getContactHelper().getContactCount();

        if (! app.getContactHelper().isThereAContact()) {
            if (!app.getGroupHelper().isThereAGroup()) {
                app.getGroupHelper().createGroup(new GroupForm("test1", null, null));
            }
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname",   "test1"), true);
        }
        app.getNavigationHelper().GoToHome();
        app.getContactHelper().selectContact(before-1);
        app.getContactHelper().selectContactEdit(before-1);
        app.getContactHelper().deleteContact();
        app.getNavigationHelper().GoToHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}

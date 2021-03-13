package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

public class ContactDeleteTest extends TestBase {
    @Test
    public void testContactDelete() {
        app.getNavigationHelper().GoToHome();

        if (! app.getContactHelper().isThereAContact()) {
            if (!app.getGroupHelper().isThereAGroup()) {
                app.getGroupHelper().createGroup(new GroupForm("test1", null, null));
            }
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname",   "test1"), true);
        }
        app.getNavigationHelper().GoToHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().selectContactEdit();
        app.getContactHelper().deleteContact();
    }
}

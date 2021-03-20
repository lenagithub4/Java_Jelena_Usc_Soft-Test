package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getNavigationHelper().GoToHome();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname",   "test1"), true);
        }
        app.getContactHelper().selectContact(before-1);
        app.getContactHelper().selectContactEdit(before-1);
        app.getContactHelper().fillContactForm(new ContactData("Olga2", "Vladimirovna_modif", "Bubina_modif", null), false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().GoToHome();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before);



    }
}

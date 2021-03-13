package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getNavigationHelper().GoToHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname",   "test1"), true);
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().selectContactEdit();
        app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna_modif", "Bubina_modif", null), false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().GoToHome();



    }
}

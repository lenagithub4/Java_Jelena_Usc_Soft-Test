package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getNavigationHelper().GoToHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().selectContactEdit();
        app.getContactHelper().fillContactForm(new ContactData("Olga", "Vladimirovna", "Bubina", "Olga", "BBB", "Dublin", "22233355", "olga-usc@inbox.lv", "28", "April", "1978", "Riga", "test1", "Riga", "catalog entry2"));
        app.getContactHelper().updateContact();
        app.getNavigationHelper().GoToHome();



    }
}

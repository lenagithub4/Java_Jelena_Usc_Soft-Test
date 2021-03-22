package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase{
    @Test
    public void testContactModification() {
        app.getNavigationHelper().GoToHome();
        List<ContactData> before = app.getContactHelper().getContactList();
        //int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname", "test1"), true);
        }
        app.getContactHelper().selectContact(before.size()-1);
        app.getContactHelper().selectContactEdit(before.size()-1);
        ContactData entry = new ContactData(before.get(before.size()-1).getId(),"Olga2", "Vladimirovna_modif", "Bubina_modif", null);   //I have deleted the group approve b: true/false
       //app.getContactHelper().fillContactForm(new ContactData("Olga2", "Vladimirovna_modif", "Bubina_modif", null), false);
        app.getContactHelper().fillContactForm(entry, false);
        app.getContactHelper().updateContact();
        app.getNavigationHelper().GoToHome();
        List<ContactData> after = app.getContactHelper().getContactList();
       // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size());

         // Lesson 4.7
        before.remove(before.size()-1);
       before.add(entry);
        Comparator<? super ContactData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        before.sort(byId);
        after.sort(byId);
       Assert.assertEquals(before, after);

    }
}

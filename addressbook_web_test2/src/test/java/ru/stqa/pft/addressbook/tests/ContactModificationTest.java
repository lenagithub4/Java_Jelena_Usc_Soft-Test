package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase{

    public void ensurePreconditions() {
        app.goTo().GoToHome();

        if (!app.getContactHelper().isThereAContact()) {
            if (!app.group().isThereAGroup()) {
                app.group().create(new GroupForm().withName("test1"));
            }
            app.getContactHelper().createContact(new ContactData("Name", "Name2", "Surname", "test1"), true);
        }
    }

    @Test(enabled=true)
    public void testContactModification() {
        //app.goTo().GoToHome();
        List<ContactData> before = app.getContactHelper().getContactList();
                  //int before = app.getContactHelper().getContactCount();
        int index = before.size() - 1;
        ContactData entry = new ContactData(before.get(index).getId(),"Olga2", "Vladimirovna_modif", "Bubina_modif", null);   //I have deleted the group approve b: true/false
        //app.getContactHelper().fillContactForm(new ContactData("Olga2", "Vladimirovna_modif", "Bubina_modif", null), false); app.goTo().GoToHome();
        app.getContactHelper().modifyContract(index, entry);

        List<ContactData> after = app.getContactHelper().getContactList();
       // int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size());

         // Lesson 4.7
        before.remove(index);
       before.add(entry);
        Comparator<? super ContactData> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        before.sort(byId);
        after.sort(byId);
       Assert.assertEquals(before, after);

    }


}

package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().list().size() == 0) {
            app.group().create(new GroupForm().withName("test1"));
        }

    }

    @Test
    public void testGroupModification() {


        Set<GroupForm> before = app.group().all();
        // before = app.getGroupHelper().getGroupCount(); //check count of groups before modif
        GroupForm modifiedGroup = before.iterator().next();
        //int index = before.size() - 1;  ne nuzen
        GroupForm group = new GroupForm()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2 modif").withFooter("test3 modif"); // Id formula
        app.group().modify(group);
        //int after = app.getGroupHelper().getGroupCount(); //check count of groups after modif
        Set<GroupForm> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        //Lection 4.7. non-sorted collections
        before.remove(modifiedGroup);
        before.add(group);
        //Lekcija 4.10
        //Comparator<? super GroupForm> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); // Variant 2 lists comparition
        Assert.assertEquals(before, after);
    }


}


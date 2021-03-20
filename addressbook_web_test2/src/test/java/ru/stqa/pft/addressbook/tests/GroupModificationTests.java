package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();

        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupForm("test1", null, null));
        }
        List<GroupForm> before = app.getGroupHelper().getGroupList();
        // before = app.getGroupHelper().getGroupCount(); //check count of groups before modif
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().initGroupModification();
        GroupForm group = new GroupForm(before.get(before.size()-1).getId(),"test1", "test2 modif", "test3 modif"); // Id formula
        app.getGroupHelper().fillGroupForm(group);

        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPage();
        //int after = app.getGroupHelper().getGroupCount(); //check count of groups after modif
        List<GroupForm> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        //Lection 4.7. non-sorted collections
        before.remove(before.size()-1);
        before.add(group);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); // Variant 2 lists comparition
    }
}


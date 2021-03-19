package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

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
        app.getGroupHelper().fillGroupForm(new GroupForm("test1", "test2 modif", "test3 modif"));

        app.getGroupHelper().submitGroupModification();
        app.getNavigationHelper().gotoGroupPage();
        //int after = app.getGroupHelper().getGroupCount(); //check count of groups after modif
        List<GroupForm> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals( after.size(), before.size());


    }
}


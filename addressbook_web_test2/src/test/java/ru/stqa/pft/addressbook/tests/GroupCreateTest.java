package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.HashSet;
import java.util.List;


public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupForm> before = app.getGroupHelper().getGroupList();
        //int before = app.getGroupHelper().getGroupCount(); //check count of groups before addition
        GroupForm group = new GroupForm("test2", null, null);
        app.getGroupHelper().createGroup(group);
        app.getNavigationHelper().gotoGroupPage();
        List<GroupForm> after = app.getGroupHelper().getGroupList();
        // int after = app.getGroupHelper().getGroupCount(); //check count of groups after addition
        Assert.assertEquals(after.size(), before.size() + 1);

/* old max function */
        //int max = 0;
        //for (GroupForm q : after) {
        //    if (q.getId() > max) {
        //        max = q.getId();
         //   }
        //}


       // Comparator<? super GroupForm> byId = (Comparator<GroupForm>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId()); //Lekcija 4.9

        //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); // Lekcija 4.8
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); // Variant 2 lists comparition

        //app.getGroupHelper().initGroup();
        //app.getGroupHelper().fillGroupForm(new GroupForm("test1", null, null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getNavigationHelper().gotoGroupPage();
        //app.getGroupHelper().select();
        //app.getGroupHelper().returnGroupPage();
    }


}



package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;


public class GroupCreateTest extends TestBase {


    @Test
    public void testGroupCreate() throws Exception {



        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount(); //check count of groups before addition
        app.getGroupHelper().createGroup(new GroupForm("test1", null, null));
        app.getNavigationHelper().gotoGroupPage();
        int after = app.getGroupHelper().getGroupCount(); //check count of groups after addition
        Assert.assertEquals( after, before + 1);

        //app.getGroupHelper().initGroup();
        //app.getGroupHelper().fillGroupForm(new GroupForm("test1", null, null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getNavigationHelper().gotoGroupPage();
        //app.getGroupHelper().select();
        //app.getGroupHelper().returnGroupPage();
    }


}



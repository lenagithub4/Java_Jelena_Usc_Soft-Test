package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;


public class GroupCreateTest extends TestBase {


    @Test
    public void GroupCreateTest() throws Exception {

        app.getGroupHelper().gotoGroupPage();
        app.getGroupHelper().initGroup();
        app.getGroupHelper().fillGroupForm(new GroupForm("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().gotoGroupPage();
        app.getGroupHelper().select();
        app.getGroupHelper().returnGroupPage();
    }


}



package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;


public class GroupCreateTest extends TestBase {


    @Test
    public void GroupCreateTest() throws Exception {

        app.gotoGroupPage();
        app.initGroup();
        app.fillGroupForm(new GroupForm("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.gotoGroupPage();
        app.select();
        app.returnGroupPage();
    }


}



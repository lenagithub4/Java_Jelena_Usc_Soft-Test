package ru.stqa.pft.addressbook.tests;

import org.junit.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getGroupHelper().gotoGroupPage();
        app.getGroupHelper().SelectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupForm("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnGroupPage();

    }
}


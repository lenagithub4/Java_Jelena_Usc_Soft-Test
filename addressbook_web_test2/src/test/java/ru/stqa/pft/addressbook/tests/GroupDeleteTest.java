package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.awt.*;
import java.util.List;


public class GroupDeleteTest extends TestBase {


  @Test
  public void testGroupDelete() {

    app.getNavigationHelper().gotoGroupPage();

    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupForm("test1", null, null));

    }
    List<GroupForm> before = app.getGroupHelper().getGroupList();
    //int before = app.getGroupHelper().getGroupCount(); //check count of groups before deletion
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().DeleteGroup();
    app.getNavigationHelper().gotoGroupPage();
    List<GroupForm> after = app.getGroupHelper().getGroupList();
    //int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    Assert.assertEquals( after.size(), before.size() - 1);

}

}

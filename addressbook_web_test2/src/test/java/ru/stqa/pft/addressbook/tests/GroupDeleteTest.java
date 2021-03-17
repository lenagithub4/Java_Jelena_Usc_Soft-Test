package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;


public class GroupDeleteTest extends TestBase {


  @Test
  public void testGroupDelete() {

    app.getNavigationHelper().gotoGroupPage();
    int before = app.getGroupHelper().getGroupCount(); //check count of groups before deletion
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupForm("test1", null, null));

    }


    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().DeleteGroup();
    app.getNavigationHelper().gotoGroupPage();
    int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    Assert.assertEquals( after, before - 1);

}

}

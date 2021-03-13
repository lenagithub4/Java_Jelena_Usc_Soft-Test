package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;


public class GroupDeleteTest extends TestBase {


  @Test
  public void testGroupDelete() {
    app.getNavigationHelper().gotoGroupPage();
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupForm("test1", null, null));

    }
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().DeleteGroup();
    app.getGroupHelper().returnGroupPage();

}

}

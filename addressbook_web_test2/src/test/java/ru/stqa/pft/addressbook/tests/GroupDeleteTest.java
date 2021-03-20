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
    List<GroupForm> after = app.getGroupHelper().getGroupList();  // count of groups after deleting
    //int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    Assert.assertEquals( after.size(), before.size() - 1); // is count before and after is equals?

   // collections (Lists) comparition. Lection 4.6
    before.remove(before.size() - 1); // back before list to preview state (for Variant 1, Variant 2)
     for (int i=0; i<after.size(); i++) { // no necessary Variant 1
       Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
     }// no necessary Variant 1
  //  Assert.assertEquals(before, after); // Variant 2
}

}

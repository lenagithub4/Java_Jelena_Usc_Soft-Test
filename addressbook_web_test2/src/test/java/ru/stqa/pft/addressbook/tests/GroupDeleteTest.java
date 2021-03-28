package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.List;
import java.util.Set;


public class GroupDeleteTest extends TestBase {

  @BeforeMethod  //Lekcija 5.2 Preconditions
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupForm().withName("test1"));
    }

  }

  @Test
  public void testGroupDelete() {

    Set<GroupForm> before = app.group().all();
    //int before = app.getGroupHelper().getGroupCount(); //check count of groups before deletion
    GroupForm deletedGroup = before.iterator().next();
    //int index = before.size() - 1;  /*Lekcija 5.6 delete int index */
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    app.goTo().groupPage();
    Set<GroupForm> after = app.group().all();  // count of groups after deleting
    //int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    Assert.assertEquals( after.size(), before.size() - 1); // is count before and after is equals?

   // collections (Lists) comparition. Lection 4.6
    before.remove(deletedGroup); // back before list to preview state (for Variant 1, Variant 2)
    // for (int i=0; i<after.size(); i++) { // no necessary Variant 1
    //   Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
    // }// no necessary Variant 1
   Assert.assertEquals(before, after); // Variant 2
}



}

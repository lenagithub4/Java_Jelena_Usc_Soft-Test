package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;

import java.util.List;


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

    List<GroupForm> before = app.group().list();
    //int before = app.getGroupHelper().getGroupCount(); //check count of groups before deletion
    int index = before.size() - 1;
    app.goTo().groupPage();
    app.group().delete(index);
    app.goTo().groupPage();
    List<GroupForm> after = app.group().list();  // count of groups after deleting
    //int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    Assert.assertEquals( after.size(), index); // is count before and after is equals?

   // collections (Lists) comparition. Lection 4.6
    before.remove(index); // back before list to preview state (for Variant 1, Variant 2)
     for (int i=0; i<after.size(); i++) { // no necessary Variant 1
       Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
     }// no necessary Variant 1
   //Assert.assertEquals(before, after); // Variant 2
}



}

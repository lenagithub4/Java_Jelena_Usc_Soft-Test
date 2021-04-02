package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupDeleteTest extends TestBase {

  @BeforeMethod  //Lekcija 5.2 Preconditions
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupForm().withName("test1"));
    }

  }

  @Test(enabled=true)
  public void testGroupDelete() {

    Groups before = app.group().all();
    //int before = app.getGroupHelper().getGroupCount(); //check count of groups before deletion
    GroupForm deletedGroup = before.iterator().next();
    //int index = before.size() - 1;  /*Lekcija 5.6 delete int index */
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    app.goTo().groupPage();
    Groups after = app.group().all();  // count of groups after deleting
    //int after = app.getGroupHelper().getGroupCount(); //check count of groups after deletion
    assertEquals( after.size(), before.size() - 1); // is count before and after is equals?

   // collections (Lists) comparition. Lection 4.6
    //before.remove(deletedGroup); // back before list to preview state (for Variant 1, Variant 2)
    // for (int i=0; i<after.size(); i++) { // no necessary Variant 1
    //   Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
    // }// no necessary Variant 1
    assertThat(after, equalTo(before.withOut(deletedGroup)));
   //Assert.assertEquals(before, after); // Variant 2
}



}

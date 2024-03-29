package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;
import ru.stqa.pft.addressbook.model.Groups;

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
    GroupForm deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    app.goTo().groupPage();
    assertEquals(app.group().count(), (before.size() - 1));// is count before and after is equals?
    Groups after = app.group().all();  // count of groups after deleting
    // collections (Lists) comparition. Lection 4.6
    //before.remove(deletedGroup); // back before list to preview state (for Variant 1, Variant 2)
    // for (int i=0; i<after.size(); i++) { // no necessary Variant 1
    //   Assert.assertEquals(before.get(i), after.get(i));// no necessary Variant 1
    // }// no necessary Variant 1
    assertThat(after, equalTo(before.withOut(deletedGroup))); /*proverjalka Hamcrest L.5.6 */
   //Assert.assertEquals(before, after); // Variant 2
}



}

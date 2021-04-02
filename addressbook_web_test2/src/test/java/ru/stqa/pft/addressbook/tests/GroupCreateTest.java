package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class GroupCreateTest extends TestBase {


    @Test (enabled=true)
    public void testGroupCreate() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        //int before = app.getGroupHelper().getGroupCount(); //check count of groups before addition
        GroupForm group = new GroupForm().withName("test2");
        app.group().create(group);
        app.goTo().groupPage();
        Groups after = app.group().all();
        // int after = app.getGroupHelper().getGroupCount(); //check count of groups after addition
        assertEquals(after.size(), (before.size() + 1));

           /* old max function */
        //int max = 0;
        //for (GroupForm q : after) {
        //    if (q.getId() > max) {
        //        max = q.getId();
         //   }
        //}


       // Comparator<? super GroupForm> byId = (Comparator<GroupForm>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId()); //Lekcija 4.9

        //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
       // group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()); // Lekcija 4.8


       //before.add(group);
        /* lection 5.6 hide 3 lines below */
      //  Comparator<? super GroupForm> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
      //  before.sort(byId);
      //  after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); // Variant 2 lists comparition
        //Assert.assertEquals(before, after); /*udalitj */
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt())))); /*proverjalka */

        //app.getGroupHelper().initGroup();
        //app.getGroupHelper().fillGroupForm(new GroupForm("test1", null, null));
        //app.getGroupHelper().submitGroupCreation();
        //app.getNavigationHelper().gotoGroupPage();
        //app.getGroupHelper().select();
        //app.getGroupHelper().returnGroupPage();
    }


}



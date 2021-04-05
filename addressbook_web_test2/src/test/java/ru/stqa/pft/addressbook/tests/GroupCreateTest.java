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
        GroupForm group = new GroupForm().withName("test2");
        app.group().create(group);
        app.goTo().groupPage();
        assertEquals(app.group().count(), (before.size() + 1));
        Groups after = app.group().all();
                assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt())))); /*proverjalka Hamcrest L.5.6 */


    }

    @Test (enabled=true)
    public void testBadGroupCreate() {

        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupForm group = new GroupForm().withName("test'");
        app.group().create(group);
        app.goTo().groupPage();
        assertEquals(app.group().count(), (before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before)); /*proverjalka Hamcrest L.5.6 */


    }


}



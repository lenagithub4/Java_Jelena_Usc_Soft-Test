package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupForm;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if (app.group().all().size() == 0) {
            app.group().create(new GroupForm().withName("test1"));
        }

    }

    @Test(enabled=false)
    public void testGroupModification() {

        Groups before = app.group().all();
        // before = app.getGroupHelper().getGroupCount(); //check count of groups before modif
        GroupForm modifiedGroup = before.iterator().next();
        //int index = before.size() - 1;  ne nuzen
        GroupForm group = new GroupForm()
                .withId(modifiedGroup.getId()).withName("test1").withHeader("test2 modif").withFooter("test3 modif"); // Id formula
        app.group().modify(group);
        //int after = app.getGroupHelper().getGroupCount(); //check count of groups after modif
        Groups after = app.group().all();
        assertEquals(after.size(), before.size());

        //Lection 4.7. non-sorted collections
        //before.remove(modifiedGroup);
        //before.add(group);
        //Lekcija 4.10
        //Comparator<? super GroupForm> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        //before.sort(byId);
        //after.sort(byId);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object> (after)); // Variant 2 lists comparition
        //Assert.assertEquals(before, after);
        assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));


    }


}


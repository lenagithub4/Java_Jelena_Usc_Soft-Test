package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;


public class GroupDeleteTest extends TestBase {


  @Test
  public void testGroupDelete() {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().SelectGroup();
    app.getGroupHelper().DeleteGroup();
    app.getGroupHelper().returnGroupPage();

  }

}

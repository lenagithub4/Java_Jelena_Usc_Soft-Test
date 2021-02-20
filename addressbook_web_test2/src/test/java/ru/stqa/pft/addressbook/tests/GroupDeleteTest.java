package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;


public class GroupDeleteTest extends TestBase {


  @Test
  public void testGroupDelete() {
    app.gotoGroupPage();
    app.SelectGroup();
    app.DeleteGroup();
    app.returnGroupPage();

  }

}

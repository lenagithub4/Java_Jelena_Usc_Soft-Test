package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class GroupCreateTest extends TestBase {


    @Test
    public void GroupCreateTest() throws Exception {

        gotoGroupPage();
        initGroup();
        fillGroupForm(new GroupForm("test1", "test2", "test3"));
        submitGroupCreation();
        gotoGroupPage();
        select();
        returnGroupPage();
    }


}



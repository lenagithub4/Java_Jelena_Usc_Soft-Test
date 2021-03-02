package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {
    @Test
    public void testContactDelete() {
        app.getNavigationHelper().GoToHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().selectContactEdit();
        app.getContactHelper().deleteContact();
    }
}

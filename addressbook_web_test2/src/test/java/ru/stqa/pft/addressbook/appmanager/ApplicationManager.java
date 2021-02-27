package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private ContactData.NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {

        wd = new ChromeDriver();
        WebDriver.Timeouts implicitlyWait = wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new ContactData.NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        //login
        sessionHelper.login("admin", "secret");
    }



    public void logout() {
        groupHelper.returnGroupPage();
    }

    public void stop() {
        wd.quit();
    }



    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public ContactData.NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}

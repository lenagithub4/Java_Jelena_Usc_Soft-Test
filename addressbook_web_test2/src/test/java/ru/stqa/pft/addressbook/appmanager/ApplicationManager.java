package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    private WebDriver wd;
    private ContactHelper contactHelper;
    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;

    public void init() {

        wd = new ChromeDriver();
        WebDriver.Timeouts implicitlyWait = wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

       wd.get("http://localhost/addressbook/");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
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

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}

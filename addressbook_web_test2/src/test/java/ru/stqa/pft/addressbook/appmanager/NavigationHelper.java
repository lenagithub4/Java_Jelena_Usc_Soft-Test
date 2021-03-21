package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1")) && isElementPresent(By.name("new"))) {
            /* wd.findElement(By.tagName("h1")).getText().equals("Groups") && - error*/
            return;
        }
        click(By.linkText("groups"));
    }

    public void GoToHome() {
        if (isElementPresent(By.id("maintable")) && isElementPresent(By.id("MassCB"))) {
            return;
        }
        click(By.linkText("home"));
    }
}

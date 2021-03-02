package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupForm;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnGroupPage() {
        click(By.linkText("Logout"));
    }

    public void select() {
        click(By.name("selected[]"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupForm groupForm) {
        type(By.name("group_name"), groupForm.getName());
        type(By.name("group_header"), groupForm.getHeader());
        type(By.name("group_footer"), groupForm.getFooter());
    }

    public void initGroup() {
        click(By.name("new"));
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void DeleteGroup() {
        click(By.name("delete"));
    }

    public void SelectGroup() {
        click(By.name("selected[]"));
    }


    public void initGroupModification() { click(By.name("edit"));  }

    public void submitGroupModification() {  click(By.name("update"));  }




}

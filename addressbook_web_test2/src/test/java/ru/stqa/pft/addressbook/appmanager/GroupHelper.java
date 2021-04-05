package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupForm;
import ru.stqa.pft.addressbook.model.Groups;
import java.util.HashSet;

import java.util.List;

public class GroupHelper extends HelperBase{

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnGroupPage() {
        click(By.linkText("Logout"));
    }

    //public void select() { click(By.name("selected[]"));    }// not used

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

    public void DeleteGroup() {
        click(By.name("delete"));
    }
    public void delete(GroupForm group) {

        selectGroupById(group.getId());
        DeleteGroup();
        groupCache = null;
    }

   // public void selectGroup(int index) {
   //     wd.findElements(By.name("selected[]")).get(index).click();// not used

   // }
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+id+"']")).click();

    }

    public void initGroupModification() { click(By.name("edit"));  }

    public void submitGroupModification() {  click(By.name("update"));  }


    public void create(GroupForm group){
        gotoGroupPage();
        initGroup();
       fillGroupForm(group);
       submitGroupCreation();
        groupCache = null;
       // gotoGroupPage();
       //select();
       //returnGroupPage();

    }
    public void modify(GroupForm group) {
      selectGroupById(group.getId());
      initGroupModification();
      fillGroupForm(group);
      submitGroupModification();
        groupCache = null;
      gotoGroupPage();
    }
    //public void delete(int index) {
     //   selectGroup(index);
      //  DeleteGroup();
   // }

    private void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1")) && wd.findElement(By.tagName("h1")).getText().equals("Groups") && isElementPresent(By.name("new"))) {

            return;
        }
        click(By.linkText("groups"));
    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size(); //find list of groups by name

    }
   // not used yet
   // public List<GroupForm> list() {
   //     List<GroupForm> groups = new ArrayList<GroupForm>();
    //    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    //    for (WebElement element : elements) {
     //       String name = element.getText();
    //        int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
     //       //GroupForm group = new GroupForm().withId(id).withName(name); deleted and group in the line below is changed on...
     //       groups.add(new GroupForm().withId(id).withName(name));
     //   }
     //   return groups;
   // }

    /* keshirovanie. L 5.7. */
    private Groups groupCache = null;

    public Groups all() {
        if (groupCache != null) {
            return new Groups (groupCache);
        }
        groupCache = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id= Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            //GroupForm group = new GroupForm().withId(id).withName(name); deleted and group in the line below is changed on...
            groupCache.add(new GroupForm().withId(id).withName(name));
        }
        return new Groups (groupCache);
    }




    }


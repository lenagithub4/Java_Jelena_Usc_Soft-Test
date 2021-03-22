package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper  extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void AddNewContact() {
        click(By.linkText("add new"));
    }

    public void submitForm() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {

        type(By.name("firstname"), contactData.getName());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getSurname());

        // type(By.name("nickname"), contactData.getNick());
        // type(By.name("company"), contactData.getCompany());
        // type(By.name("address"), contactData.getCity());
        // type(By.name("home"), contactData.getPhone());
        // type(By.name("email"), contactData.getEmail());
        // click(By.name("bday"));
        // select(By.name("bday"), contactData.getBday());
        // click(By.name("bday"));
        // click(By.name("bmonth"));
        // select(By.name("bmonth"), contactData.getBmonth());
        // click(By.name("bmonth"));
        // type(By.name("byear"), contactData.getByear());
        // type(By.name("address2"), contactData.getCity2());
        //click(By.name("new_group"));
        //select(By.name("new_group"), contactData.getTest1());
        // click(By.name("new_group"));
        // type(By.name("phone2"), contactData.getPhone2());
        // type(By.name("notes"), contactData.getNotes());

      /* find group selection tab in contacts */
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }


    public void selectContact(int index) {
             wd.findElements(By.name("selected[]")).get(index).click();


    }

    public void selectContactEdit(int index) {
               wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click();
    }

    public void updateContact() {
        // click(By.xpath("//input[@name='update'])[2]"));
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void deleteContact() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void createContact(ContactData contacts, boolean b) {
     AddNewContact();
     fillContactForm(contacts, b);
     submitForm();
       GoToHome();
     //  logout();
    }

    private void GoToHome() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }



    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    // count contacts Lekcija 4.3
    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contactsList = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr"));
            elements.remove(0);  // delete 1st row of table (header)
            for (WebElement element : elements) {
                List<WebElement> entry = element.findElements(By.cssSelector("td"));

                String lastname = entry.get(1).getText();
                String firstname = entry.get(2).getText();
                int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
                ContactData contact = new ContactData(id, firstname,null, lastname, null);
                contactsList.add(contact);
            }

        return contactsList;
    }
}

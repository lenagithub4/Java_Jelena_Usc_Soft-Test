package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {
    // static is added (lection 5.1) in the row below
    protected static final  ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    //@BeforeMethod(alwaysRun = true) //was before 5 Lection)

    @BeforeSuite  // 1 Browser window for all tests lekcija 5.1
    public void setUp() throws Exception {
        app.init();
    }

   // @AfterMethod(alwaysRun = true)//was before 5 Lection)
    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();

    }

}

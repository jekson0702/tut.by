import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InboxPage;
import pages.LoginPage;
import singletonWebDriver.SingletonWebDriver;

public class InboxPageTest {
    private static final int NUMBER_OF_MESSAGES = 3;
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @BeforeClass
    public void beforeClass() {
        loginPage = new LoginPage();
        inboxPage = new InboxPage();
        loginPage.loadMainPage();
        loginPage.loginAsCorrectUser();
        loginPage.goToInbox();
    }

    @Test
    public void countMessagesTest() {
        //If you want to know the number of emails
        System.out.println("Number of messages: " + inboxPage.countMessages());
        //If you want to compare the number of emails in the mailbox with the expected number
        Assert.assertEquals(NUMBER_OF_MESSAGES, inboxPage.countMessages());
    }

    @AfterClass
    public void afterClass() {
        SingletonWebDriver.quitDriver();
    }
}
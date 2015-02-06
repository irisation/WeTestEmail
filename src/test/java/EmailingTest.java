import core.TestBase;
import helpers.Waiter;
import junit.framework.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailBoxPage;

import static helpers.WebDriverSingleton.getDriver;

public class EmailingTest extends TestBase {

    @Test
    public void emailSendingTest() {
        LoginPage.login("testuse1@tut.by", "testuser1");
        MailBoxPage.sendEmail("Hi", "testuse2@tut.by", "This is a test message");
        Waiter.waitForJavascriptFinished(getDriver());
        Assert.assertTrue(MailBoxPage.isSent());
        MailBoxPage.exit();
        getDriver().get(BASE_URL);
        LoginPage.login("testuse2@tut.by", "testuser2");

    }
}

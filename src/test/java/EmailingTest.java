import core.TestBase;
import helpers.Waiter;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MailBoxPage;

import java.text.DateFormat;
import java.util.Date;

import static helpers.WebDriverSingleton.getDriver;

public class EmailingTest extends TestBase {

    @Test
    public void emailSendingTest() {
        String subj = generateSubject();
        LoginPage.login("testuse1@tut.by", "testuser1");
        MailBoxPage.sendEmail(subj, "testuse2@tut.by", "This is a test message");
        Waiter.waitForJavascriptFinished(getDriver());
        Assert.assertTrue(MailBoxPage.isSent());
        MailBoxPage.exit();
        getDriver().get(BASE_URL);
        LoginPage.login("testuse2@tut.by", "testuser2");
        Assert.assertTrue(pageContainsText(subj));

    }

    private boolean pageContainsText(String text) {
        WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'" + text + "')]"));
        return element != null;
    }

    private String generateSubject() {
        return "Test" + DateFormat.getDateTimeInstance().format(new Date());
    }
}

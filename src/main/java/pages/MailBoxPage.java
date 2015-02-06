package pages;

import helpers.Waiter;
import org.openqa.selenium.By;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class MailBoxPage {
    public static final By WRITE_BUTTON = get("mailBoxPage.writeButton");
    public static final By SUBJECT_FIELD = get("mailBoxPage.subject");
    public static final By TO_ADDRESS_FIElD = get("mailBoxPage.to");
    public static final By BODY_FIElD = get("mailBoxPage.body");
    public static final By SEND_BUTTON = get("mailBoxPage.sendButton");
    public static final By IS_SENT_MESSAGE = get("mailBoxPage.isSentMessage");
    public static final By HEADER_USERNAME = get("mailBoxPage.headerUsername");
    public static final By EXIT_LINK = get("mailBoxPage.exitLink");

    private static void typeInfo(By field, String info) {
        getDriver().findElement(field).clear();
        getDriver().findElement(field).sendKeys(info);
        Waiter.waitForJavascriptFinished(getDriver());
    }

    public static void sendEmail(String subject, String toAddress, String body) {
        getDriver().findElement(WRITE_BUTTON).click();
        Waiter.waitForJavascriptFinished(getDriver());
        typeInfo(SUBJECT_FIELD, subject);
        typeInfo(TO_ADDRESS_FIElD, toAddress);
        typeInfo(BODY_FIElD, body);
        getDriver().findElement(SEND_BUTTON).click();
    }

    public static void exit() {
        getDriver().findElement(HEADER_USERNAME).click();
        Waiter.waitForJavascriptFinished(getDriver());
        getDriver().findElement(EXIT_LINK).click();
    }

    public static boolean isSent() {
        return getDriver().findElement(IS_SENT_MESSAGE).getText().equals("Письмо успешно отправлено.");
    }
}

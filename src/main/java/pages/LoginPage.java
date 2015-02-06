package pages;

import org.openqa.selenium.By;

import static helpers.Locators.get;
import static helpers.WebDriverSingleton.getDriver;

public class LoginPage {
    public static final By USERNAME_FIELD = get("loginPage.usernameField");
    public static final By PASSWORD_FIELD = get("loginPage.passwordField");
    public static final By LOGIN_BUTTON = get("loginPage.loginButton");

    public static void login(String username, String pass) {
        getDriver().findElement(USERNAME_FIELD).clear();
        getDriver().findElement(USERNAME_FIELD).sendKeys(username);
        getDriver().findElement(PASSWORD_FIELD).clear();
        getDriver().findElement(PASSWORD_FIELD).sendKeys(pass);
        getDriver().findElement(LOGIN_BUTTON).click();
    }
}

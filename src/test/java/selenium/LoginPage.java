package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By emailField = By.id("field_email");
    private final By passwordField = By.id("field_password");
    private final By loginButton = By.xpath("//input[@data-l='t,sign_in']");
    private final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public UserPage loginByPhone(String phone, String pwd) {
        webDriver.findElement(emailField).click();
        webDriver.findElement(emailField).clear();
        webDriver.findElement(emailField).sendKeys(phone);

        webDriver.findElement(passwordField).click();
        webDriver.findElement(passwordField).clear();
        webDriver.findElement(passwordField).sendKeys(pwd);
        webDriver.findElement(loginButton).click();
        return new UserPage(webDriver);
    }


}

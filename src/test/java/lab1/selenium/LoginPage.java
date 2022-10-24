package lab1.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By emailLocator = By.id("field_email");
    private final By passwordLocator = By.id("field_password");
    private final By loginButtonLocator = By.xpath("//input[@data-l='t,sign_in']");
    private final String TITLE_RU = "Социальная сеть Одноклассники. Общение с друзьями в ОК. Ваше место встречи с одноклассниками";
    private final WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
        if (!TITLE_RU.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page");
        }
    }

    public LoginPage typeEmail(String phone) {
        driver.findElement(emailLocator).click();
        driver.findElement(emailLocator).clear();
        driver.findElement(emailLocator).sendKeys(phone);
        return this;
    }

    public LoginPage typePassword(String pwd) {
        driver.findElement(passwordLocator).click();
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(pwd);
        driver.findElement(loginButtonLocator).click();
        return this;
    }


    public UserPage loginByPhone(String phone, String pwd) {
        typeEmail(phone);
        typePassword(pwd);
        return new UserPage(driver);
    }


}

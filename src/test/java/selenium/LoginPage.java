package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebElement emailField;
    private WebElement passwordField;
    private WebElement loginButton;

    public LoginPage(WebDriver webDriver) {
        emailField = webDriver.findElement(By.id("field_email"));
        passwordField = webDriver.findElement(By.id("field_password"));
        loginButton = webDriver.findElement(By.xpath("//input[@data-l='t,sign_in']"));
    }

    public void loginByPhone(String phone, String pwd){
        emailField.click();
        emailField.clear();
        emailField.sendKeys(phone);

        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(pwd);
        loginButton.click();
    }


}

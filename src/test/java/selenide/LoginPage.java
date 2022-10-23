package selenide;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final static SelenideElement emailField = $(byId("field_email"));
    private final static SelenideElement passwordField = $(byId("field_password"));
    private final static SelenideElement loginButton = $(byXpath("//input[@data-l='t,sign_in']"));

    public LoginPage open() {
        Selenide.open("/");
        return this;
    }

    public UserPage loginByPhone(String phone, String pwd) {
        emailField.val(phone);
        passwordField.val(pwd);
        loginButton.click();
        return new UserPage();
    }

}

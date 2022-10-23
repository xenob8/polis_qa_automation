package selenide;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class LoginTest {

    LoginPage loginPage = new LoginPage();
    public static final String PHONE = "+79650829041";
    public static final String PASSWORD = "bot_sergey";
    public static final String USERNAME = "Сергей Солодовников";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://ok.ru/";
    }

    @Test
    public void login(){
        loginPage.open().loginByPhone(PHONE, PASSWORD).getUserPage().shouldHaveText(USERNAME);
    }
}

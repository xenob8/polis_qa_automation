package selenide;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class LoginTest {

    LoginPage loginPage = new LoginPage();
    public static final String PHONE = "+79650829041";
    public static final String PASSWORD = Dotenv.load().get("password");
    public static final String USERNAME = "Сергей Солодовников";

    @BeforeAll
    public static void setUp() {
        Configuration.baseUrl = "https://ok.ru/";
    }

    @Test
    public void login() {
        loginPage.open().loginByPhone(PHONE, PASSWORD).shouldHaveText(USERNAME);
    }
}

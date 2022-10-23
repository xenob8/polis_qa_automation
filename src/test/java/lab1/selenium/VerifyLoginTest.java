package lab1.selenium;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Вариант задания посложнее - написать один тест,
//        который будет открывать браузер и заходить на сайт ok.ru,
//        далее нужно проверить логин юзером на сайт, как мы обсуждали на занятии

public class VerifyLoginTest {

    private static final String CHROME_DRIVER_PATH = "C:\\webDrivers\\chromeDriver-7\\chromedriver.exe";
    private static final String CHROME_PATH = "C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe";

    public static final String PHONE = "+79650829041";
    public static final String PASSWORD = Dotenv.load().get("password");
    public static final String NAME = "Сергей Солодовников";
    private static WebDriver driver;

    public static final String URL = "https://ok.ru/";

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_PATH);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(URL);
    }

    @Test
    public void main() {
        assertEquals(new LoginPage(driver).loginByPhone(PHONE, PASSWORD).getVisibleUserName(), NAME);
    }

    @AfterAll
    public static void tearDown() {
        driver.quit();
    }


}

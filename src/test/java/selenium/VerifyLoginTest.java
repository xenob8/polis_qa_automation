package selenium;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Вариант задания посложнее - написать один тест,
//        который будет открывать браузер и заходить на сайт ok.ru,
//        далее нужно проверить логин юзером на сайт, как мы обсуждали на занятии

public class VerifyLoginTest {

    private static final String CHROME_DRIVER_PATH = "C:\\webDrivers\\chromeDriver-7\\chromedriver.exe";
    private static final String CHROME_PATH = "C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe";

    public static final String PHONE = "+79650829041";
    public static final String PASSWORD = "bot_sergey";
    public static final String NAME = "Сергей Солодовников";
    private static WebDriver driver;

    public static final String URL = "https://ok.ru/";

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_PATH);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(URL);

    }

    @Test
    public void main() throws InterruptedException {

        new LoginPage(driver).loginByPhone(PHONE, PASSWORD);

        WebElement element = driver.findElement(UserPage.userInfoPath);
        System.out.println(element.getText());

        assertTrue(new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElementLocated(UserPage.userInfoPath, NAME)));

        driver.quit();
    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }


}

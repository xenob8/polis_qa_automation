package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UserPage {

    private final WebDriver webDriver;
    private static final By userInfoPath = By.xpath("//a[@data-l='t,userPage']/div[@class='tico ellip']");

    public UserPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getVisibleUserName() {
        return new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(userInfoPath)).getText();
    }
}

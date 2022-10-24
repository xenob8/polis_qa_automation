package lab1.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class UserPage {

    private final WebDriver driver;
    private static final By userInfoLocator = By.xpath("//a[@data-l='t,userPage']/div[@class='tico ellip']");

    public UserPage(WebDriver webDriver) {
        this.driver = webDriver;
        if (!driver.getTitle().equals("Одноклассники")) {
            throw new IllegalStateException("This is not Home Page of logged in user," +
                    " current page is: " + driver.getCurrentUrl());
        }
    }

    public String getVisibleUserName() {
        return new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(userInfoLocator)).getText();
    }
}

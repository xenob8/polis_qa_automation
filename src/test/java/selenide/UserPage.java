package selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class UserPage {
    private final static ElementsCollection userData = Selenide.$$(By.xpath("//a[@data-l='t,userPage']/div[@class='tico ellip']"));

    public void shouldHaveText(String data) {
        userData.shouldHave(CollectionCondition.texts(data));
    }
}

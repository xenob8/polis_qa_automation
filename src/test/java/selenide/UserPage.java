package selenide;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

public class UserPage {
    private final static ElementsCollection userData = Selenide.$$(By.xpath("/html/body/div[10]/div[5]/div[5]/div[1]/div/div[2]/div[1]/div[3]/div[1]/div/div/div[3]/div/div/div/div[1]/a/div"));

    public void shouldHaveText(String data){
        userData.shouldHave(CollectionCondition.texts(data));
    }
}

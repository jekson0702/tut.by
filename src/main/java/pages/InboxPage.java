package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import singletonWebDriver.SingletonWebDriver;
import waits.Waits;

import java.util.List;

public class InboxPage {
    private WebDriver driver = SingletonWebDriver.getDriver();
    private Waits waits = new Waits();

    @FindBy(xpath = "//div[@data-key='box=messages-item-box']")
    private List<WebElement> messagesList;

    public InboxPage() {
        PageFactory.initElements(driver, this);
    }

    public int countMessages() {
        waits.expectVisibilityOfAllElements(messagesList);
        return messagesList.size();
    }
}
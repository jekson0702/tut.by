package waits;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import singletonWebDriver.SingletonWebDriver;

import java.util.List;

public class Waits {
    private static final int TIMEOUT = 15;
    private WebDriver driver = SingletonWebDriver.getDriver();

    public void expectVisibility(WebElement webElement) {
        new WebDriverWait(driver, TIMEOUT).
                until(ExpectedConditions.visibilityOf(webElement));
    }

    public void expectVisibilityOfAllElements(List<WebElement> list) {
        new WebDriverWait(driver, TIMEOUT).
                until(ExpectedConditions.visibilityOfAllElements(list));
    }

    public void expectClickableAndClick(WebElement webElement) {
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }
}
package pages;

import configuration.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import singletonWebDriver.SingletonWebDriver;
import waits.Waits;

public class LoginPage {
    private WebDriver driver = SingletonWebDriver.getDriver();
    private Waits waits = new Waits();

    @FindBy(xpath = "//a[@data-target-popup='authorize-form']")
    private WebElement authorizeForm;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//a[@title='Почта']")
    private WebElement mailbox;

    @FindBy(xpath = "//input[@class='button auth__enter']")
    private WebElement enterButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void loadMainPage() {
        driver.get(Configuration.getMainUrl());
    }

    public void loginAsCorrectUser() {
        waits.expectClickableAndClick(authorizeForm);
        waits.expectVisibility(loginField);
        loginField.clear();
        loginField.sendKeys(Configuration.getLogin());
        passwordField.clear();
        passwordField.sendKeys(Configuration.getPassword());
        enterButton.click();
    }

    public void goToInbox() {
        waits.expectClickableAndClick(mailbox);
    }
}

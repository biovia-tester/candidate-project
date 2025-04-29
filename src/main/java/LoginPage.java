import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class LoginPage {

    WebDriver driver;
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By continueBtn = By.cssSelector("input.uwa-input-submit");
    By loginBtn = By.cssSelector("input.uwa-input-submit");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {

        Wait<WebDriver> wait = WaitFactory.Create(driver);
        WebElement userElm = wait.until(driver -> driver.findElement(usernameField));
        userElm.sendKeys(username);

        WebElement continueElm = wait.until(driver -> driver.findElement(continueBtn));
        continueElm.click();

        WebElement passwordElm = wait.until(driver -> driver.findElement(passwordField));
        passwordElm.sendKeys(password);

        WebElement loginElm = wait.until(driver -> driver.findElement(loginBtn));
        loginElm.click();
    }
}

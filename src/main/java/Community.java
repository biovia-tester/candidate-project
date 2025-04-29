import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

public class Community {

    WebDriver driver;

    By root = By.className("community-context");
    By contentListContainer = By.className("community-contents-list-container");

    By post = By.className("content-summary-view");

    By scrollContainer = By.className("contents-feed-scroller");

    public Community(WebDriver driver) {
        this.driver = driver;
    }

    public List<CommunityPost> posts() {

        Wait<WebDriver> wait = WaitFactory.Create(driver);
        WebElement rootElm = wait.until(driver -> driver.findElement(root));
        List<CommunityPost> posts = wait.until(driver -> rootElm.findElements(post)).stream().map(elm -> new CommunityPost(driver, elm)).toList();

        return posts;
    }

    public void scroll(int xAmount, int yAmount) {
        Wait<WebDriver> wait = WaitFactory.Create(driver);
        WebElement rootElm = wait.until(driver -> driver.findElement(root));
        WebElement scrollElm = wait.until(driver -> rootElm.findElement(scrollContainer));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(scrollElm);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, xAmount, yAmount)
                .perform();
    }
}

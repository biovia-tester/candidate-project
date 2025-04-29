import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommunityPost {

    WebDriver driver;
    WebElement root;

    public CommunityPost(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
    }
}

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;

class BioviaCommunitiesTest {

    static final String TEST_URL = System.getProperty("TEST_URL");
    static final String TEST_USER = System.getProperty("TEST_USER");
    static final String TEST_PASS = System.getProperty("TEST_PASS");
    static final int LONG_WAIT = Integer.valueOf(System.getProperty("LONG_WAIT", "20"));


    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void scrollTest() {
        // 1. Opens the 3DExperience Platform in a browser and signs into the User Communities section of the application.
        driver.get(TEST_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TEST_USER, TEST_PASS);

        // 2. Wait for the first couple of posts to load.
        Wait<WebDriver> wait = WaitFactory.Create(driver);
        wait.until(driver -> !new Community(driver).posts().isEmpty());

        // TODO: Candidate challenge below
        // 3. Keeping scrolling the browser downward until at least 20 posts have loaded in the forum.
        int maxPostSize = 20;

        // 4. Verify that the title of each post contains text (is not empty).

        // 5. Write the titles of all the posts that are loaded to a text file called "titles.txt"
        String filePath = "titles.txt";
    }
}
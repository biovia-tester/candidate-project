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
        driver.get(TEST_URL);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TEST_USER, TEST_PASS);

        Wait<WebDriver> wait = WaitFactory.Create(driver);
        wait.until(driver -> {
            Community userCommunity = new Community(driver);
            return userCommunity.posts().size() > 0;
        });

        Community userCommunity = new Community(driver);
        List<CommunityPost> posts = userCommunity.posts();

        assertThat(posts.size()).isGreaterThan(1);

        // Candidate challenge below
        int maxPostSize = 20;
        int scrollAmount = 500;
        String filePath = "titles.txt";

        // TODO
    }
}
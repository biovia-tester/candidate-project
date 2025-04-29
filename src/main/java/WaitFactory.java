import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitFactory {

    public static Wait<WebDriver> Create(WebDriver driver) {
        int waitTime = Integer.valueOf(System.getProperty("LONG_WAIT", "20"));
        int interval = Integer.valueOf(System.getProperty("WAIT_INTERVAL", "1"));
        return Create(driver, waitTime, interval);
    }

    public static Wait<WebDriver> Create(WebDriver driver, int maxTime, int pollInterval) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(maxTime))
                .pollingEvery(Duration.ofSeconds(pollInterval))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
        return wait;
    }
}

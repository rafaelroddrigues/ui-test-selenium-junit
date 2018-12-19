package espera;

import browser.Chrome;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class Espera {

    private static long delay = 0L;

    public static void esperaSpinBarSumir() {
        esperaElementoSumir("");
    }

    public static void esperaElementoSumir(String selector) {
        new FluentWait<>(Chrome.getDriver())
            .withTimeout(Duration.ofSeconds(40))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(selector)));
    }

    public static void esperaElementoAparecer(String selector) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new FluentWait<>(Chrome.getDriver())
            .withTimeout(Duration.ofSeconds(40))
            .pollingEvery(Duration.ofMillis(500))
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

}

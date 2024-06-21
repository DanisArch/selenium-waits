import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitsTests extends BaseTest {

    private WebElement revealed;

    @Test
    void waitsImplicitTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        driver.findElement(By.id("adder")).click();

//        Thread.sleep(4000);
 /*       WebElement box0 = driver.findElement(By.id("box0"));
        Assertions.assertEquals("redbox", box0.getAttribute("class"));
        WebElement box1 = driver.findElement(By.id("box1"));
        Assertions.assertEquals("redbox", box1.getAttribute("class"));
*/
        List<WebElement> redBoxes = driver.findElements(By.xpath("//div[starts-with (@id,'box')]"));
        int countRedBoxes = redBoxes.size();
        System.out.println("countRedBoxes = " + countRedBoxes);
    }

    @Test
    void waitsExplicitTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
        driver.findElement(By.id("adder")).click();
        WebElement box0 = driver.findElement(By.id("box0"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(d -> box0.isDisplayed());

        Assertions.assertEquals("redbox", box0.getAttribute("class"));

    }

}

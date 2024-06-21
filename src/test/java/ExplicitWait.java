import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.Duration;

public class ExplicitWait extends BaseTest {

    @Test
    void newTabTest () throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows/");
        WebElement tabButton = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("tabButton"))));
       boolean tabButtom =  driver.findElement(By.id("tabButton")).isEnabled();
        System.out.println("tabButtom = " + tabButtom);
        tabButton.click();
        Thread.sleep(2000);
        WebElement newTab = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body"))));
        driver.switchTo().window("window handle");
        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println("title = " + title);
        Thread.sleep(3000);
        //       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
 //       Thread.sleep(3000);
//        wait.until(d -> revealed.isDisplayed());

    }
/*
    @Test
    void helloWorldTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.findElement(By.cssSelector("#start > button")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish > h4"));

        wait.until(ExpectedConditions.visibilityOf(text));

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    void helloWorldTestLambdaWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("#start > button")).click();
        WebElement text = driver.findElement(By.cssSelector("#finish > h4"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(x -> text.isDisplayed());

        Assert.assertEquals(text.getText(), "Hello World!");
    }

    @Test
    void waitForEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[text()='Enable']")).click();

        WebElement input = driver.findElement(By.cssSelector("#input-example > input[type=text]"));

        wait.until(ExpectedConditions.elementToBeClickable(input));

        input.sendKeys("Hello world!");

        WebElement message = driver.findElement(By.cssSelector("#message"));
        Assert.assertEquals(message.getText(), "It's enabled!");
    }*/
}




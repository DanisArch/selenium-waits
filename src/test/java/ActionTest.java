import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class ActionTest extends BaseTest {

    @Test
    void actionRightClickMe () throws InterruptedException {
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Thread.sleep(3000);
       driver.manage().window().maximize();
/*        WebElement iFrame = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.id("gdpr-consent-manager")));
        ((JavascriptExecutor)driver)
                .executeScript("arguments[0].remove();", iFrame);
        driver.findElement(By.id("save")).click();*/

        driver.switchTo().frame("gdpr-consent-manager");
        WebElement accept = driver.findElement(By.cssSelector("#save"));
        accept.click();
        Thread.sleep(2000);
//        DesiredCapabilities dc = new DesiredCapabilities();
     //   dc.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT,false);

//        driver.findElement(By.id("save")).click();
        WebElement rightClickButton = driver.findElement(By.className("context-menu-one"));

        Actions clickable = null;
                new Actions(driver)
                        .doubleClick(rightClickButton)
                        .perform();

        String text = driver.switchTo().alert().getText();

        Assertions.assertTrue(text.contains("You double clicked me.. Thank You."));


    }
/*
    @Test
    public void doubleClick_test() {
        WebElement doubleClickBtn = driver.findElement(By.xpath("//[@id='authentication']/button"));
        Actions action = new Actions(driver);
        action.doubleClick(doubleClickBtn).perform();
        String text = driver.switchTo().alert().getText();

        Assertions.assertTrue(text.contains("You double clicked me.. Thank You."));
    }
*//*
String browser = ConfigurationReader.get("browser");
    WebDriver driver;
        switch (browser) {
        case "chrome" -> {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            if (ConfigurationReader.get("headless").toLowerCase().contains("true")) {
                options.addArguments("--headless");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-infobars");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-notifications");
                options.addArguments("--lang=en-en");
            }
            driver = new ChromeDriver(options);
            if (ConfigurationReader.get("maximize").toLowerCase().contains("true")) {
                driver.manage().window().maximize();
            }
            return driver;
        }
        case "firefox" -> {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        case "edge" -> {
            if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                throw new WebDriverException("Ваша операционная система не поддерживает запуск браузера Edge");
            }
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
    }

        throw new WebDriverException("WebDriver не выбран в конфигурационном файле configuration.properties");
}*/
}

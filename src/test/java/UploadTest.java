import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UploadTest extends BaseTest {

    @Test
    void uploadTest() throws InterruptedException {
        driver.get("https://github.com/login");
        WebElement login = driver.findElement(By.name("login"));
        login.click();
        login.sendKeys("DanisArch");
        WebElement pass = driver.findElement(By.name("password"));
        pass.click();
        pass.sendKeys("");
        WebElement signInButton = driver.findElement(By.name("commit"));
        signInButton.click();
        driver.get("https://github.com/settings/profile");
        Thread.sleep(2000);// Xpath for Edit button



        WebElement file = driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/summary/div")); //link text locator for uploading a photo..
        file.click();
        Thread.sleep(2000);
        WebElement addFile = driver.findElement(By.xpath("//*[@id=\"settings-frame\"]/div[2]/div[2]/dl/dd/div/details/details-menu/label"));
        addFile.click();
// Mention the own path of the file location

// Add file method
        addFile.sendKeys("C:\\Users\\User\\Downloads\\hacker.jpg");// For setting a profile picture

        driver.findElement(By.linkText("Set new profile picture")).click();
        Thread.sleep(2000);// Image name can be of your choice

        if (driver.findElement(By.xpath(".//a[text()='hacker.jpg']")).isDisplayed()) {
            assertTrue(true, "Profile picture is Uploaded");
        } else {
            assertTrue(false, "Profile picture not Uploaded");

        }
    }
}

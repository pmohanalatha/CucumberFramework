package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class PageFactoryBase {

    public static void waitUntilElementPresent(WebDriver driver, WebElement element) {
        try{
            Wait<WebDriver> wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOf(element));

//            WebDriverWait wait = new WebDriverWait(driver, 30);
//            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void sleep(int timeInSeconds){
        try{
            Thread.sleep(timeInSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

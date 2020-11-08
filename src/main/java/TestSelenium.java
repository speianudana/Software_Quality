import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestSelenium {
    public static void main(String[] args) {
        //Setting system properties of ChromeDriver
        File file = new File("C:/Users/User/Downloads/chromedriver.exe");

        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        //Creating an object of ChromeDriver
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();

        //Deleting all the cookies
        chromeDriver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        chromeDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        chromeDriver.get("https://www.google.com/");

        // Search for "computer"
        WebElement element = chromeDriver.findElement(By.name("q"));
        element.sendKeys("computer");
        element.submit();


        Assert.assertTrue(chromeDriver.getTitle().contains("Google"));


        Assert.assertTrue(chromeDriver.findElement( By.xpath("//*[@id=\"logo\"]/img")).isDisplayed()) ;

        chromeDriver.close();

    }
}

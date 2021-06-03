package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Test01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.google.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("tester");

        driver.findElement(By.xpath("//div[@class='jyfHyd']")).click();

        List<WebElement> results = driver.findElements(By.xpath("//li[@class='sbct']"));

        for (WebElement w : results) {
            System.out.println(w.getText());
        }
        for (WebElement w : results) {
            if (w.getText().equalsIgnoreCase("testere almanca")){
                w.click();
                break;
            }
        }


    }
}

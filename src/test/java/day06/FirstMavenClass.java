package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);

        WebElement aramaSonucWebElement = driver.findElement(By.xpath("//span[@dir='auto'][1]"));
        String aramaSonuc = aramaSonucWebElement.getText();
        System.out.println(aramaSonuc);

        driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")).click();

        driver.navigate().back();

        List<WebElement> tümBasliklarList = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));
        for (WebElement each : tümBasliklarList) {
            if (each.getText() != " ") {
                System.out.println(each.getText());
            }
        }

        driver.close();

    }
}

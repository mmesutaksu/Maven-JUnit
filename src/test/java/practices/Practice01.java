package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Practice01 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void index(){
        WebElement dropDownElement = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropDownElement);
        select.selectByIndex(3);
    }
    @Test
    public void value(){
        WebElement dropDownElement = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(dropDownElement);

        System.out.println(select.getFirstSelectedOption().getText());
        select.selectByValue("option3");
    }
}

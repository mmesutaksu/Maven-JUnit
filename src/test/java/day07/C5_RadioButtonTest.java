package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C5_RadioButtonTest {
    /*
        1. Bir class oluşturun : RadioButtonTest
        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        https://www.facebook.com adresine gidin
        “Create an Account” button’una basin
        “radio buttons” elementlerini locate edin
        Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @After
    public void teraDown(){
        driver.close();
    }


    @Test
    public void test01() {
        driver.get("http://facebook.com/");
        driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement radioButtons = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        if (!radioButtons.isSelected()) {
            radioButtons.click();
        }
    }
}

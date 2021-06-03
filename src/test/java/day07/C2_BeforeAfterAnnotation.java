package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_BeforeAfterAnnotation {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

    @Test
    public void test01() {

        driver.get("http://techproeducation.com");
    }

    @Test
    public void test02() {

        driver.get("http://amazon.com");
    }

    @Test
    public void test03() {

        driver.get("http://facebook.com");
    }


}

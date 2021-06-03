package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C2_YanlisEmailTest {
    /*
        Bir Class olusturalim YanlisEmailTesti
        http://automationpractice.com/index.php sayfasina gidelim
        Sign in butonuna basalim
        Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda “Invalid email address” uyarisi ciktigini test edelim
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
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void titleTest(){

        // http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");

        //Sign in butonuna basalim
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //  Email kutusuna @isareti olmayan bir mail yazip enter’a basalim
        WebElement emailKutusu = driver.findElement(By.id("email_create"));
        emailKutusu.sendKeys("mesutaksugmail.com");
        emailKutusu.submit();

        // “Invalid email address” uyarisi ciktigini test edelim
        WebElement uyari = driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        String expectedUyari = "Invalid email address";
        String actualUyari = uyari.getText();

        Assert.assertTrue(actualUyari.equals(expectedUyari));
    }
}

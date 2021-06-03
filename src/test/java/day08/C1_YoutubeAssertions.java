package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C1_YoutubeAssertions {
    /*
    1) Bir class oluşturun: YoutubeAssertions
    2) https://www.youtube.com adresine gidin
    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
        ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
        ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
        ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        ○ wrongTitleTest  => Sayfa basliginin “youtube” olmadigini dogrulayin

     */
    WebDriver driver;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://youutube.com/");
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void titleTest(){
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div[1]/div/button/span")).click();
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void imageTest(){
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div[1]/div/button/span")).click();
        WebElement logo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div[1]/div/button/span")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/div/div[2]/div[1]/div[4]/form/div[1]/div/button/span")).click();
        String actualTitle = driver.getTitle();
        String expectedWrongTitle = "youtube";

        Assert.assertFalse(actualTitle.equals(expectedWrongTitle));
    }

}

package practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Practice02 {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        //driver.close();
    }

    /*
    1. kraloyun.com sayfasina git
    2. sign in butonuna tikla
    3. email kutusuna @ olmadan mail yazip ENTER yap
    4. hata yazisi alip almadigini  test et
    5. eger hata yazisi alirsan dogru bir email gir ENTER yap
    6. username ve passwordu doldur ENTER yap
     */

    @Test @Ignore
    public void test01() throws InterruptedException {
        driver.get("https://dictionary.cambridge.org/tr/");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("(//span[@class='tb'])[2]")).click();

        driver.get("https://dictionary.cambridge.org/tr/auth/signup?rid=amp-ZSvOgo8eFTsgvwfqcxLxsA&return=https%3A%2F%2Fcdn.ampproject.org%2Fv0%2Famp-login-done-0.1.html%3Furl%3Dhttps%253A%252F%252Fdictionary.cambridge.org%252Ftr%252F");

        WebElement emailBox = driver.findElement(By.xpath("(//input[@name='email'])[3]"));
        emailBox.sendKeys("mstaksu52@gmail.com");

        WebElement firstNameBox = driver.findElement(By.xpath("(//input[@name='profile.firstName'])[2]"));
        firstNameBox.sendKeys("Mesut");

        WebElement lastNameBox = driver.findElement(By.xpath("(//input[@name='profile.lastName'])[2]"));
        lastNameBox.sendKeys("Aksu");

        WebElement passwordBox = driver.findElement(By.xpath("(//input[@name='password'])[3]"));
        passwordBox.sendKeys("xxxxxx");

        WebElement passwordBox2 = driver.findElement(By.xpath("(//input[@name='passwordRetype'])[3]"));
        passwordBox2.sendKeys("xxxxxx");

        WebElement tikBox = driver.findElement(By.xpath("(//input[@name='data.press.terms.v1.blnAccepted'])[3]"));
        tikBox.click();

        WebElement signUpButonu = driver.findElement(By.xpath("(//input[@class='gigya-input-submit'])[7]"));
        signUpButonu.click();
    }

    @Test
    public void test02(){
        driver.get("https://dictionary.cambridge.org/tr/");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("(//span[@class='tb'])[1]")).click();

        driver.get("https://dictionary.cambridge.org/tr/auth/signin?rid=amp-w_i-3mmoMxD-cyM-yMK5qQ&return=https%3A%2F%2Fcdn.ampproject.org%2Fv0%2Famp-login-done-0.1.html%3Furl%3Dhttps%253A%252F%252Fdictionary.cambridge.org%252Ftr%252F");

        WebElement emailBox = driver.findElement(By.xpath("(//input[@name='username'])[3]"));
        emailBox.sendKeys("mstaksu52@gmail.com");

        WebElement passwordBox = driver.findElement(By.xpath("(//input[@name='password'])[3]"));
        passwordBox.sendKeys("xxxxxxxx");
        passwordBox.submit();

    }
}

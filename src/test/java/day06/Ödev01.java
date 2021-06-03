package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ödev01 {
    public static void main(String[] args) {
        /*
        1-Test01 isimli bir class olusturun
        2- https://www.walmart.com/ adresine gidin
        3- Browseri tam sayfa yapin
        4-Sayfayi “refresh” yapin
        5- Sayfa basliginin “Save” ifadesi icerdigini control edin
        6-Sayfa basliginin “Walmart.com | Save Money.Live Better” a esit oldugunu control ediniz
        7- URL in walmart.com icerdigini control edin
        8-”Nutella” icin arama yapiniz
        9- Kac sonuc bulundugunu yaziniz
        10-Sayfayi kapatin
        */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.walmart.com/");
        driver.navigate().refresh();
        String t = driver.getTitle();
        String u = driver.getCurrentUrl();

        System.out.println("Title");
        if (!t.contains("Save")) {
            System.out.println("Bu Title 'Save' ifadesi icermiyor. FAILD \nDogru Title: "+t);
        } else{
            System.out.println("Bu Title 'Save' ifadesi iceriyor. PASS");
        }

        if (t.equals("Walmart.com | Save Money.Live Better")) {
            System.out.println("Bu Title 'Walmart.com | Save Money.Live Better' degildir . FAILD \nDogru Title: "+t);
        }else{
            System.out.println("Bu Title 'Walmart.com | Save Money.Live Better'dir. PASS");
        }

        System.out.println("URL");
        if (!u.contains("walmart.com")) {
            System.out.println("Bu URL 'walmart.com' ifadesi icermiyor. FAILD \nDogru URL: "+u);
        }else{
            System.out.println("Bu URL 'walmart.com' ifadesi iceriyor. PASS");
        }

        WebElement aramaKutusu = driver.findElement(By.id("global-search-input"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonuclarWebElement = driver.findElement(By.xpath("//div[@class='result-summary-container']"));
        System.out.println("\nSonuclar: \n"+sonuclarWebElement.getText());

        driver.close();





    }
}

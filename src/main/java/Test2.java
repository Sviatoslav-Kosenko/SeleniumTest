import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
//Построение маршрута для вида транспорта "Общественный транспорт"
public class Test2 {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://yandex.ru/maps/2/saint-petersburg/?ll=30.318615%2C59.928680&z=14");

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//a[@class='button _view_search _size_medium _link']"));
        element.click();
        WebElement element1 = driver.findElement(By.xpath("//div[@class='route-travel-modes-view__mode _mode_masstransit']"));
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Откуда']"));
        element2.sendKeys("Исаакиевский собор");
        element2.sendKeys(Keys.DOWN);
        element2.sendKeys(Keys.ENTER);
        System.out.println(element2.getAccessibleName());
        System.out.println(element2.getAttribute("value"));
        WebElement element3 = driver.findElement(By.xpath("//input[@placeholder='Куда']"));
        element3.sendKeys("Казанский собор");
        element3.sendKeys(Keys.DOWN);
        element3.sendKeys(Keys.ENTER);
        System.out.println(element2.getAccessibleName());
        System.out.println(element2.getAttribute("value"));

        WebElement element4 = driver.findElement(By.xpath("//div[@class='masstransit-route-snippet-view__route-duration']"));
        System.out.println(element4.getText());
        WebElement element5 = driver.findElement(By.xpath("//div[@class='masstransit-route-snippet-view__route-hint']"));
        System.out.println(element5.getText());
    }
}

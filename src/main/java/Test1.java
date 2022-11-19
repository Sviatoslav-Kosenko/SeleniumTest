
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
//Построение маршрута для вида транспорта "Личный авто"
public class Test1 {
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
        WebElement element1 = driver.findElement(By.xpath("//input[@placeholder='Откуда']"));
        element1.sendKeys("Исаакиевский собор");
        element1.sendKeys(Keys.DOWN);
        element1.sendKeys(Keys.ENTER);
        System.out.println(element1.getAccessibleName());
        System.out.println(element1.getAttribute("value"));

        WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Куда']"));
        element2.sendKeys("Казанский собор");
        element2.sendKeys(Keys.DOWN);
        element2.sendKeys(Keys.ENTER);
        System.out.println(element2.getAccessibleName());
        System.out.println(element2.getAttribute("value"));

        WebElement element3 = driver.findElement(By.xpath("//div[@class='auto-route-snippet-view__route-title-primary']"));
        System.out.println(element3.getText());
        WebElement element4 = driver.findElement(By.xpath("//div[@class='auto-route-snippet-view__arrival']"));
        System.out.println(element4.getText());
        WebElement element5 = driver.findElement(By.xpath("//div[@class='auto-route-snippet-view__route-subtitle']"));
        System.out.println(element5.getText());
    }
}

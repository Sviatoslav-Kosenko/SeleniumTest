package adblock;
import java.io.File;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;




public class AdblockDemo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sviatoslav\\IdeaProjects\\AutoTest\\src\\driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\Sviatoslav\\IdeaProjects\\AutoTest\\src\\driver\\extension_3_6_14_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        //driver.quit();
    }
}

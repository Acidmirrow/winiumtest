import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.$;

public class test {
    static WiniumDriver driver = null;
    static WiniumDriverService service = null;
    static DesktopOptions options = null;


    @BeforeClass
    public static void setup () throws IOException {
        options = new DesktopOptions();
        File driverPath = new File("src/main/resources/Winium.Desktop.Driver.exe");
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999).withVerbose(true).withSilent(false).buildDesktopService();
        service.start();
    }

    @Before
    public void startDriver () {
        WiniumDriver driver = new WiniumDriver(service,options);
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void test1 () throws MalformedURLException, InterruptedException {
        SelenideElement calcFrame = $(By.className("CalcFrame"));
        SelenideElement menu = calcFrame.$(By.id("MenuBar"));
        SelenideElement viewMenu = menu.$(By.name("View"));
        viewMenu.click();
        viewMenu.$(By.id("132")).click();
        viewMenu.$(By.id("93")).click();
    }
}

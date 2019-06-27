import com.codeborne.selenide.WebDriverRunner;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.close;

public class notepadtest {


    @Test
    public void test() throws IOException {
        DesktopOptions options= new DesktopOptions();
        options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
            WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
            driver.findElementByClassName("Edit").sendKeys("This is sample test");
            driver.close();


    }

    @Test
    public void selenidetest () throws MalformedURLException {
        DesktopOptions options= new DesktopOptions();
        options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
        WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
        WebDriverRunner.setWebDriver(driver);
        $(By.className("Edit")).setValue("123123");

    }
}

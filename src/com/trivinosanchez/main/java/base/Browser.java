package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Browser {

    public enum Name {
        Firefox, Chrome, IE, Safari
    }

    private WebDriver driver;
    private Name name;

    Browser (WebDriver driver) {
        this.driver = driver;
        if (driver instanceof FirefoxDriver) {
            name = Name.Firefox;
        } else {
            name = Name.Chrome;
        }
    }

    public void goToUrl(String url) {
        System.out.println(url);
        driver.get(url);
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void setMobileMode() {
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "Pixel 2");

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isInUrl(String url) {
        return getCurrentPageUrl().equals(url);
    }

}

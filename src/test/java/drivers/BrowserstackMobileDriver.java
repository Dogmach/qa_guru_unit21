package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static config.BrowserstackProject.authConfig;
import static config.BrowserstackProject.browserstackConfig;

public class BrowserstackMobileDriver implements WebDriverProvider {

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserstackConfig.browserstackUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public WebDriver createDriver(DesiredCapabilities caps) {

        // Set your access credentials
        System.getProperty("properties", "browserstack");

        caps.setCapability("browserstack.user", authConfig.browserstackUser());
        caps.setCapability("browserstack.key", authConfig.browserstackKey());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.device());
        caps.setCapability("os_version", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", browserstackConfig.project());
        caps.setCapability("build", browserstackConfig.build());
        caps.setCapability("name", browserstackConfig.name());


        return new AndroidDriver(getBrowserstackUrl(), caps);
    }
}
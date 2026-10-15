package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Override
    public @NonNull WebDriver createDriver(@NonNull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "ivan_t6ak4G");
        caps.setCapability("browserstack.key", "pgtYvncUin6iF6V6SjSJ");

        // Set URL of the application under test
        caps.setCapability("app", "bs://62052639d354aea7139864ba993d1cf6106ef4a3");

        // Specify device and os_version for testing
        caps.setCapability("platformName", "android");
        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");

        // Initialize the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}

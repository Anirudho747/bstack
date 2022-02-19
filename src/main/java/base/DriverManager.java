package base;

import utils.JsonParser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class DriverManager {
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return driver.get();
    }

    public static void setDriver(AppiumDriver driver1){
        driver.set(driver1);
    }

    public static void initializeDriver(String deviceID) throws Exception {
        AppiumDriver driver;
        String userName = "darshanxunison1";
        String accessKey = "p1sqaQUrCaurzrpNcway";
        String buildName = System.getenv("BROWSERSTACK_BUILD_NAME");
        String app = System.getenv("BROWSERSTACK_APP_ID");

        JSONObject deviceObj = new JSONObject(JsonParser.parse("Devices.json").getJSONObject(deviceID).toString());
        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("device", deviceObj.getString("device"));
        caps.setCapability("os_version", deviceObj.getString("os_version"));
        caps.setCapability("project", "browserstack");
        caps.setCapability("build", "build Name");
        caps.setCapability("name", "build Test 01");
        caps.setCapability("app", deviceObj.getString("app_url"));

        URL url = new URL("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub");

        switch (deviceID){
            case "1":
                driver = new AndroidDriver(url, caps);
                break;
            case "2":
                driver = new IOSDriver(url, caps);
                break;
            default:
                throw new IllegalStateException("invalid device id" + deviceID);
        }
        setDriver(driver);
    }
}

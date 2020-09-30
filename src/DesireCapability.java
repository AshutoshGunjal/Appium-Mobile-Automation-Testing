import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DesireCapability {
	public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		File f = new File("src");
		File file = new File(f,"ApiDemos-debug.apk");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Ash");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIA utomator2");
		//cap.setCapability(MobileCapabilityType.APP, file);
		cap.setCapability("ApiDemos-debug.apk", file);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("https://127.0.0.1:4723/wd/hub"), cap);
		
		return driver;
	}
}

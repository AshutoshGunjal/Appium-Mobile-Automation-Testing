import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MobileGestures extends DesireCapability {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("\\android.widget.TextView(@text='Views')").click();
		
		
		// how to tap on mobile (TouchAction)
		TouchAction touchActions = new TouchAction(driver);
		
		WebElement expandList = driver.findElementByXPath("\\android.widget.TextView(@text='Expandable Lists')");
		touchActions.tap(tapOptions().withElement(element(expandList))).perform();
		
		//long press touch
		driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
		WebElement webElement = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");
		touchActions.longPress(longPressOptions().withElement(element(webElement)).withDuration(ofSeconds(2))).release().perform();
		Thread.sleep(2000);
		
	}
}

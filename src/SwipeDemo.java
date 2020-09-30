import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SwipeDemo extends DesireCapability {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("\\android.widget.TextView(@text='Views')").click();
		driver.findElementByXPath("\\android.widget.TextView(@text='Date Widgets')").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		//click on 9 with regular expression * with xpaths
		driver.findElementByXPath("//*[content-desc='9']").click();
		
		//swipe from 15 to 45 i.e. 180 degrees with touch actions class
		// long press on element for 2 sec and move to another element and release 
		TouchAction touchActions = new TouchAction(driver);
		
		WebElement firstElement = driver.findElementByXPath("//*[content-desc='15']");
		WebElement secondElement = driver.findElementByXPath("//*[content-desc='45']");
		
		touchActions.longPress(longPressOptions().withElement(element(firstElement)).withDuration(ofSeconds(2)))
			.moveTo(element(secondElement)).release().perform();
		
		
		
	}

}

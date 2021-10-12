package SeleniumCoreFunctions;

import java.util.Set;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumCommands {

	public static WebDriver driver;

	public void init(String url) {

		System.setProperty("webdriver.chrome.driver", "D:\\Work\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public void cleanUp() {

		driver.quit();

	}
	
	public void closeCurrentWindow() {

		driver.close();

	}

	public void click(String locator, String byOperator) throws Exception {

		WebElement ele = findElement(locator, byOperator);
		if (ele == null)
		{
			throw new Exception("Could not click on the element. Locator: "+ locator);
		}
		else {
			ele.click();
		}

	}

	public WebElement findElement(String locator, String byOperator) throws Exception {
		WebElement ele = null;
		Thread.sleep(1000);
		for (int count = 0; count < 10; count++) {
			try {
				ele = driver.findElement(getByOperator(locator, byOperator));
				if (ele == null) {
					Thread.sleep(1000);
				} else if (ele.isDisplayed() && ele.isEnabled()) {
					break;
				} else {
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				Thread.sleep(1000);
			}
		}
		
		return ele;
	}

	public By getByOperator(String locator, String byOperator) {

		switch (byOperator) {
		case "ClassName":
			return By.className(locator);
		case "Name":
			return By.name(locator);
		case "Id":
			return By.id(locator);
		case "Xpath":
			return By.xpath(locator);
		case "LinkText":
			return By.linkText(locator);
		case "PartialLinkText":
			return By.partialLinkText(locator);
		default:
			return By.xpath(locator);
		}

	}

	public void hoverOnWebElement(String locator, String byOperator) throws Exception {

		WebElement ele = findElement(locator, byOperator);

		Actions actions = new Actions(driver);
		Action action = actions.moveToElement(ele).build();
		action.perform();

	}

	public void selectDropdown(String val, String xpathIdentifier, String byOperator, String selectBy)
			throws Exception {

		WebElement ele = findElement(xpathIdentifier, byOperator);
		Select selectObj = new Select(ele);

		switch (selectBy) {
		case "value":
		case "Value":
			selectObj.selectByValue(val);
			break;
		case "Index":
			selectObj.selectByIndex(Integer.parseInt(val));
			break;
		case "Text":
			selectObj.selectByVisibleText(val);
			break;
		default:
			selectObj.selectByValue(val);
		}

	}

	public boolean isElementVisible(String locator, String byOperator) 
	{
		WebElement ele=null;
		try {
			ele = findElement(locator, byOperator);
		}
		catch (Exception e)
		{
			
		}
		if (ele ==null)
		{
			return false;
		}
		else 
		{
			return ele.isDisplayed();
		}
		
		
		
	}

	public String getText(String locator,String byOperator) throws Exception {
		WebElement ele = findElement(locator, byOperator);
		String name= ele.getText();
		return name;
	}
	public String getAttribute(String locator,String byOperator,String attributeName) throws Exception {
		WebElement ele = findElement(locator, byOperator);
		String name= ele.getAttribute(attributeName);
		return name;
	}
	public String getCurrentWindowHandle()
	{
		String parentWindow = driver.getWindowHandle();
		return parentWindow;
		
	}
	public Set<String> getAllWindow()
	{
		Set<String> parentWindow = driver.getWindowHandles();
		return parentWindow;
		
	}

	public void switchToWindow(String currentWin) {
		driver.switchTo().window(currentWin);
		
	}

	public void refreshWindow() {
		driver.navigate().refresh();
		
	}

}

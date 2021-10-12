package PageObjects;

import org.openqa.selenium.WebElement;

import SeleniumCoreFunctions.SeleniumCommands;

public class HeaderPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String numberOnCartXpath = "//span[text()='Cart']/preceding-sibling::div";

	public void clickOnFlipkartLogo() {

	}

	public void clickOnSearchBar() throws Exception {

		seleniumCommands.click("q", "Name");

	}

	public void enterTextOnSearchBar() {

	}

	public void clickOnCartLogo() {

	}

	public void hoverOnMore() {

	}

	public String getCartNumberOfItems() throws Exception {

		String val = seleniumCommands.getText(numberOnCartXpath, "Xpath");
		return val;
	}

	public WebElement getCartItems() throws Exception {
		WebElement ele = seleniumCommands.findElement(numberOnCartXpath, "Xpath");
		return ele;
	}

}

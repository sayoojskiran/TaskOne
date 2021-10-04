package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class HeaderPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

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

}

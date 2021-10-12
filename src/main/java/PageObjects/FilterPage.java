package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class FilterPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String selectMinFilter = "//option[@value='Min']/parent::select";
	String selectMaxFilter = "//option[@value='Max']/parent::select";

	String brandSpecificationFilter = "//div[text()='{brandName}']/parent::label";
	String brandFilter = "//div[text()='Brand']";

	public void selectMinPriceFilter(String min, String byOpratorForSelect) throws Exception {

		seleniumCommands.selectDropdown(min, selectMinFilter, byOpratorForSelect, "value");

	}

	public void selectMaxPriceFilter(String max, String byOpratorForSelect) throws Exception {

		seleniumCommands.selectDropdown(max, selectMaxFilter, byOpratorForSelect, "value");

	}

	public boolean isBrandExpanded(String brandName) throws Exception {
		String xpathValue = brandSpecificationFilter.replace("{brandName}", brandName);
		boolean result = seleniumCommands.isElementVisible(xpathValue, "Xpath");
		return result;
	}

	public void isRamSpecDisplayed() throws Exception {
		// seleniumCommands.isElementVisible("", "");

	}

	public void clickOnBrandName(String brandName) throws Exception {
		String xpathValue = brandSpecificationFilter.replace("{brandName}", brandName);
		seleniumCommands.click(xpathValue, "Xpath");

	}

	public void clickOnBrandFilter() throws Exception {
		seleniumCommands.click(brandFilter, "Xpath");

	}

	public boolean getFilterStatus(String location, String byOperator) {
		return seleniumCommands.isElementVisible(location, byOperator);
	}

}

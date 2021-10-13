package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class FilterPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String selectMinFilter = "//option[@value='Min']/parent::select";
	String selectMaxFilter = "//option[@value='Max']/parent::select";

	String filterSpecificationXpath = "//div[text()='{filterName}']/parent::label";
	String filterXpath = "//div[text()='{filter}']";

	public void selectMinPriceFilter(String min, String byOpratorForSelect) throws Exception {

		seleniumCommands.selectDropdown(min, selectMinFilter, byOpratorForSelect, "value");

	}

	public void selectMaxPriceFilter(String max, String byOpratorForSelect) throws Exception {

		seleniumCommands.selectDropdown(max, selectMaxFilter, byOpratorForSelect, "value");

	}

	public boolean isFilterExpanded(String filterName) throws Exception {
		String xpathValue = filterSpecificationXpath.replace("{filterName}", filterName);
		boolean result = seleniumCommands.isElementVisible(xpathValue, "Xpath");
		return result;
	}

	public void isRamSpecDisplayed() throws Exception {
		// seleniumCommands.isElementVisible("", "");

	}

	public void clickOnSpecificFilter(String filterName) throws Exception {
		String xpathValue = filterSpecificationXpath.replace("{filterName}", filterName);
		seleniumCommands.click(xpathValue, "Xpath");

	}

	public void clickOnFilterSection(String filter) throws Exception {
		String xpathValue = filterXpath.replace("{filter}", filter);
		seleniumCommands.click(xpathValue, "Xpath");

	}

	public boolean getFilterStatus(String location, String byOperator) {
		return seleniumCommands.isElementVisible(location, byOperator);
	}

}

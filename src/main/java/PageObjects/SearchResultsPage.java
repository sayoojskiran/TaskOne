package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class SearchResultsPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();
	String selectMinFilter = "//option[@value='Min']/parent::select";
	String selectMaxFilter = "//option[@value='Max']/parent::select";

	public void clickSortMethod(String sortBy) throws Exception {
		String sortMethodXpath = "//span[text()='Sort By']/following-sibling::div[text()='" + sortBy + "']";
		seleniumCommands.click(sortMethodXpath, "Xpath");

	}

	public void selectMinPriceFilter(String min, String byOpratorForSelect) throws Exception {

		seleniumCommands.selectDropdown(min, selectMinFilter, byOpratorForSelect, "value");
		// String dropdownXpath = "//option[@value'"+xpathIdentifier+"']/..";

	}

	public void selectMaxPriceFilter(String max, String byOpratorForSelect) throws Exception {

		// Thread.sleep(3000);
		seleniumCommands.selectDropdown(max, selectMaxFilter, byOpratorForSelect, "value");
		// seleniumCommands.selectDropdown(max, byOpratorForSelect, "Max");

	}

}

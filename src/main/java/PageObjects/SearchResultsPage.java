package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class SearchResultsPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String processorFilter = "//div[text()='Processor']";
	String processorSpecificationFilter = "//div[text()='Core i3']/parent::label";
	String processorMoreOption = "//span[text()='18 MORE']/parent::div";
	String brandFilter = "//div[text()='Brand']";
	String osFilter = "//div[text()='Operating System']";
	String osSpecificationFilter = "//div[text()='Windows 10']/parent::label";
	String ramCapacityFilter = "//div[text()='RAM Capacity']";
	String ramCapacitySpecificationFilter = "//div[text()='4 GB']/parent::label";

	String sortMethodXpath = "//span[text()='Sort By']/following-sibling::div[text()='{sortBy}']";
	String productNameXpath = "//a[contains(text(),'{productName}')]";

	public void clickSortMethod(String sortBy) throws Exception {
		String xpathValue = sortMethodXpath.replace("{sortBy}", sortBy);
		seleniumCommands.click(xpathValue, "Xpath");
	}

	public void clickProduct(String productName) throws Exception {
		String xpathValue = productNameXpath.replace("{productName}", productName);
		seleniumCommands.click(xpathValue, "Xpath");
	}

}

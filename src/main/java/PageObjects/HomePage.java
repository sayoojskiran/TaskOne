package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class HomePage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String closeLoginXpath = "//button[text()='✕']";
	String homeButtonXpath = "//div[text()='Home']/parent::a/..";
	String topOffersXpath = "//img[@alt='Top Offers']";

	public void clickOnCloseLogin() throws Exception {

		seleniumCommands.click(closeLoginXpath, "Xpath");

	}

	public void clickOnHomeButton() throws Exception {

		seleniumCommands.click(homeButtonXpath, "Xpath");

	}
	
	public void clickOnTopOffers() throws Exception {
		seleniumCommands.click(topOffersXpath,"Xpath");
	}

	public void hoverOnCategory(String categoryName) throws Exception {

		String catogoryNameXpath = "//div[@id='container']//span[text()='" + categoryName + "']";

		seleniumCommands.hoverOnWebElement(catogoryNameXpath, "Xpath");

	}

	public void clickOnFurtherSubCategory(String subCategoryName, String furtherSubCategoryName) throws Exception {
		String furtherSubCatogoryNameXpath = "//a[text()='" + subCategoryName + "']/following::a[text()='"
				+ furtherSubCategoryName + "']";
		seleniumCommands.click(furtherSubCatogoryNameXpath, "Xpath");
	}

}

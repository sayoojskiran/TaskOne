package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class CheckoutPage {
	
	SeleniumCommands seleniumCommands = new SeleniumCommands();
	
	String removeButtonXpath = "//div[text()='Remove']";
	String saveForLaterXpath = "//div[text()='Save for later']";
	String placeOrderXpath = "//span[text()='Place Order']/parent::button";
	String addQuantityOfProductXpath = "//a[contains(text(),'{productName}')]/../../../parent::div/div/div/div/button[text()='+']";
	String removeQuantityOfProductXpath = "//a[contains(text(),'{productName}')]/../../../parent::div/div/div/div/button[text()='-']";
	String productPriceXpath = "(//a[contains(text(),'{productName}')]/../parent::div/span[contains(text(),'₹')])[1]";
	String productQuantityXpath = "//a[contains(text(),'{productName}')]/../../../parent::div/div/div/div/div/input";
	
	public void clickRemoveItem() {

	}
	
	public void clickSaveForLater() {

	}
	
	public void clickPlaceOrder() {

	}

	public void increaseTheProductCount(String productName) throws Exception {
		String xpathValue = addQuantityOfProductXpath.replace("{productName}", productName);
		seleniumCommands.click(xpathValue, "Xapth");
		
	}

	public String getPriceOfProduct(String productName) throws Exception {
		String xpathValue = productPriceXpath.replace("{productName}", productName);
		return seleniumCommands.getText(xpathValue, "Xpath");
	}

	public String getQuantityOfProduct(String productName) throws Exception {
		String xpathValue = productQuantityXpath.replace("{productName}", productName);
		return seleniumCommands.getAttribute(xpathValue, "Xpath", "Value");
	}
	
	

}

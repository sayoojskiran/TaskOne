package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class ProductPage {
	
	SeleniumCommands seleniumCommands = new SeleniumCommands();
	
	String buyNowButtonXpath = "//button[text()='BUY NOW']";
	String addToCartXpath = "//button[text()='ADD TO CART']";
	String sellerNameXpath = "//div[@id='sellerName']/span/span"; 
	String warrantyXpath = "//td[text()='Warranty Summary']/following-sibling::td/ul/li";
	
	public void getProductName() {

	}
	
	public void getProductRating() {

	}
	
	public String getProductWarrantyDetails() throws Exception {
		
		String val = seleniumCommands.getText(warrantyXpath,"Xpath");
		return val;

	}
	
	public void getProductDeliveryDate() {

	}
	
	public String getProductSellerName() throws Exception {
		
		String val = seleniumCommands.getText(sellerNameXpath,"Xpath");
		return val;

	}
	
	public void clickAddToCartButton() throws Exception {
		
		seleniumCommands.click(addToCartXpath, "Xapth");
		
	}
	
	public void clickBuyNowButton() {

	}
	
}

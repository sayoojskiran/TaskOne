package PageObjects;

import org.openqa.selenium.WebElement;

import SeleniumCoreFunctions.SeleniumCommands;

public class ProductPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();

	String buyNowButtonXpath = "//button[text()='BUY NOW']";
	String addToCartXpath = "//button[text()='ADD TO CART']";
	String sellerNameXpath = "//div[@id='sellerName']/span/span";
	String warrantyXpath = "//td[text()='Warranty Summary']/following-sibling::td/ul/li";
	String productNameXpath = "//span[contains(text(),'{productName}')]";
	String productPriceXpath = "//span[contains(text(),'{productName}')]/../parent::div/following-sibling::div/div/div/div[contains(text(),'{productPrice}')]";
	String productRatingXpath = "//span[contains(@id,'productRating')]/div[text()='{productRating}']";

	public WebElement getProductName(String productName) throws Exception {

		String xpathValue = productNameXpath.replace("{productName}", productName);
//		System.out.println("Name Xpath : " + xpathValue);
		WebElement ele = seleniumCommands.findElement(xpathValue, "Xpath");

		return ele;

	}

	public boolean getProductRating(String productRating) throws Exception {

		String xpathValue = productRatingXpath.replace("{productRating}", productRating);
		boolean result = seleniumCommands.isElementVisible(xpathValue, "Xpath");
		return result;

	}

	public String getProductWarrantyDetails() throws Exception {

		String val = seleniumCommands.getText(warrantyXpath, "Xpath");
		return val;

	}

	public void getProductDeliveryDate() {

	}

	public String getProductSellerName() throws Exception {

		String val = seleniumCommands.getText(sellerNameXpath, "Xpath");
		return val;

	}

	public void clickAddToCartButton() throws Exception {

		seleniumCommands.click(addToCartXpath, "Xapth");

	}

	public void clickBuyNowButton() {

	}

	public WebElement getProductPrice(String productName, String productPrice) throws Exception {

//		System.out.println("(*(*^&^* "+productName);
		String xpathValue = productPriceXpath.replace("{productName}", productName);
//		System.out.println(" ::::::::} "+xpathValue);
		xpathValue = xpathValue.replace("{productPrice}", productPrice);
//		System.out.println(" ::::::::} "+xpathValue);
		WebElement ele = seleniumCommands.findElement(xpathValue, "Xpath");
		return ele;
	}

}

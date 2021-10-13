package Actions;

import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ExternalFileFunctions.ExternalFunctions;
import PageObjects.*;
import SeleniumCoreFunctions.SeleniumCommands;

public class ActionSetOne {

	SeleniumCommands seleniumCommands = new SeleniumCommands();
	HomePage homePageObject = new HomePage();
	HeaderPage headerPageObject = new HeaderPage();
	SearchResultsPage searchResultsPageObject = new SearchResultsPage();
	FilterPage filterPageObject = new FilterPage();
	ProductPage productPageObject = new ProductPage();
	CheckoutPage checkoutPageObject = new CheckoutPage();
	ExternalFunctions externalFunctionObject = new ExternalFunctions();

	public void openUrl(String url) throws Exception {

		seleniumCommands.init(url);
		homePageObject.clickOnCloseLogin();

	}

	public void clean() {

		seleniumCommands.cleanUp();

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to hover on a Category and
	 * click a further sub category based on the sub-category of a item. Eg: Select
	 * Fashion -> Men Footwear -> Men's Casual Shoe Parameter : categoryName :
	 * Fashion subCategoryName : Men Footwear furtherSubCategoryName : Men's Casual
	 * Shoe Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	public void selectCategory(String categoryName, String subCategoryName, String furtherSubCategoryName)
			throws Exception {

		homePageObject.clickOnTopOffers();
//		Thread.sleep(3000);
		homePageObject.hoverOnCategory(categoryName);
//		Thread.sleep(3000);
		homePageObject.clickOnFurtherSubCategory(subCategoryName, furtherSubCategoryName);

		// sc.hoverOnWebElement(categoryName);

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select the "Sort"
	 * method in the search results page. Eg: Sort By -> Relevance Parameter :
	 * sortBy : Relevance Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	public void selectSortMethod(String sortBy) throws Exception {

		searchResultsPageObject.clickSortMethod(sortBy);

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to set
	 * "Minimum & Maximum price" for a product. Parameter : min : 5000 max : 20000
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	public void selectMinMaxPriceFilter(String min, String max, String byOpratorForSelect) throws Exception {

		filterPageObject.selectMinPriceFilter(min, byOpratorForSelect);
		filterPageObject.selectMaxPriceFilter(max, byOpratorForSelect);

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Processor" if
	 * the product is a cpu/laptop. Eg: Processor -> Core i5 Parameter : core : Core
	 * i5 Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void selectProcessorFilter(String Core) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Brand Name" of
	 * the product. Eg: Brand -> HP Parameter : brandName : HP Created On : 29th
	 * Sept 2021 Updated On : 30th Sept 2021
	 */
	public void selectBrandFilter(String brandName) throws Exception {

		boolean rslt = filterPageObject.isFilterExpanded(brandName);
		if (rslt) {
			filterPageObject.clickOnSpecificFilter(brandName);
		} else {
			filterPageObject.clickOnFilterSection("Brand");
			filterPageObject.clickOnSpecificFilter(brandName);
		}

	}

	String filterAppliedXpath = "//*[text()='Filters']/ancestor::section//*[text()='{filter}']";

	public void verifyFilterApplied(String filter) {
		if (filterPageObject.getFilterStatus(filterAppliedXpath.replace("{filter}", filter), "Xpath")) {
			System.out.println("\nSuccessfully verified the filter is applied. Applied Filter : " + filter);
		} else {
			System.out.println("\nCould not apply the filter. Filter to be applied: " + filter);
		}
	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Screen Size" of
	 * the product. Eg: Screen Size -> 12 inch - 12.9 inch Parameter : screenSize :
	 * 12 inch - 12.9 inch Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void selectScreenSizeFilter(String screenSize) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select
	 * "Operating System" of the product. Eg: Screen Size -> 12 inch - 12.9 inch
	 * Parameter : screenSize : 12 inch - 12.9 inch Created On : 29th Sept 2021
	 * Updated On : 30th Sept 2021
	 */
	void selectOSFilter(String operatingSystem) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select
	 * "Customer Rating" of the product. Eg: Customer Ratings -> 4★ & above
	 * Parameter : customerRating : 4★ & above Created On : 29th Sept 2021 Updated
	 * On : 30th Sept 2021
	 */
	void selectCustomerRatingFilter(String customerRating) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Ram Type" of
	 * the product. Eg: Ram Type -> DDR4 Parameter : ramType : DDR4 Created On :
	 * 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void selectRamTypeFilter(String ramType) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "RAM Capacity"
	 * of the product. Eg: RAM Capacity -> 8 GB Parameter : ramSize : 8 GB Created
	 * On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	public void selectRamSizeFilter(String ramSize) throws Exception {

		boolean rslt = filterPageObject.isFilterExpanded(ramSize);
		if (rslt) {
			filterPageObject.clickOnSpecificFilter(ramSize);
		} else {
			filterPageObject.clickOnFilterSection("RAM Capacity");
			filterPageObject.clickOnSpecificFilter(ramSize);
		}

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Storage Size"
	 * of the product. Eg: Storage Size -> 512 GB Parameter : storageSize : 512 GB
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void selectStorageSizeFilter(String storageSize) {

	}

	public int getCartNumber() throws Exception {
		WebElement cart = headerPageObject.getCartItems();
		if (cart == null) {
			cartNumber = 0;
		} else {
			String num = headerPageObject.getCartNumberOfItems();
			cartNumber = Integer.parseInt(num);
		}
		return cartNumber;
	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to click on "Product"
	 * based on product name. Eg: Product Name -> HP Envy Core i5 10th Gen Parameter
	 * : productName : HP Envy Core i5 10th Gen Created On : 29th Sept 2021 Updated
	 * On : 30th Sept 2021
	 */
	static int cartNumber;
	static int currentCartNumber;
	static String productRating;
	static int productPriceInt;
	static String productPrice;
	static String parentWindow = "";

	public void selectProduct(String productName) throws Exception {

		currentCartNumber = getCartNumber();
		productRating = searchResultsPageObject.getProductRating(productName);
		productPrice = searchResultsPageObject.getProductPrice(productName);
		productPrice = productPrice.replace("₹", "");

//		System.out.println("Product Price : " + productPrice);

		String productPriceTemp = productPrice.replace(",", "");
		productPriceInt = Integer.parseInt(productPriceTemp);

//		System.out.println("Product Price : " + productPrice);

		searchResultsPageObject.clickProduct(productName);

		parentWindow = seleniumCommands.getCurrentWindowHandle();
		Set<String> allHandle = seleniumCommands.getAllWindow();
		Iterator<String> winIterator = allHandle.iterator();
		while (winIterator.hasNext()) {
			String currentWin = winIterator.next();
			if (!parentWindow.equals(currentWin)) {
				seleniumCommands.switchToWindow(currentWin);
			}
		}

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to verify the ram
	 * specification is same in results page and product page. Eg: Given Ram
	 * Specification -> 8 GB LPDDR4X RAM Existing Ram Specification -> 8 GB LPDDR4X
	 * RAM Parameter : ramSpecification : 8 GB LPDDR4X RAM Created On : 29th Sept
	 * 2021 Updated On : 30th Sept 2021
	 */
	void verifyRamSpecification(String ramSpecification) {
		// filterPageObject.isRamSpecDisplayed();
	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to verify the existing
	 * product name with the given product name. Eg: Given Product Name -> HP Envy
	 * Core i5 10th Gen Existing Product Name -> HP Envy Core i5 10th Gen Parameter
	 * : productName : HP Envy Core i5 10th Gen Created On : 29th Sept 2021 Updated
	 * On : 30th Sept 2021
	 */
	public void verifyProductName(String productName) throws Exception {

		WebElement ele = productPageObject.getProductName(productName);

		if (ele == null) {
			System.out.println(
					"\nCouldn't verify the product name in \"Product Deatils Page\" \nThe product name doesnot match the given product name : "
							+ productName);
		} else {
			System.out.println(
					"\nSuccessfully verified the product name in \"Product Deatils Page\" and is : " + productName);
		}

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to verify the existing
	 * product price with the given product price. Eg: Given Product Price ->
	 * ₹78,990 Existing Product Price -> ₹78,990 Parameter : productPrice : ₹78,990
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	public void verifyProductPrice(String productName) throws Exception {

//		System.out.println(" <><><<><><> "+productName);
		WebElement ele = productPageObject.getProductPrice(productName, productPrice);

		if (ele == null) {
			System.out.println(
					"\nCouldn't verify the product price in \"Product Deatils Page\" \nThe price in both pages doesnot match : "
							+ productPriceInt);
		} else {
			System.out.println("\nSuccessfully verified the product price in \"Product Deatils Page\" and is : "
					+ productPriceInt);
		}

	}

	public void verifyProductRating() throws Exception {

		boolean val = productPageObject.getProductRating(productRating);

		if (val) {
			System.out.println(
					"\nSuccessfully verified the product rating in \"Product Deatils Page\" : " + productRating);
		} else {
			System.out.println("\nCouldn't verify the product rating in \"Product Deatils Page\" : " + productRating);
		}

	}

	void verifyNumberOfItemsInCart(int numberOfItems) {

	}

	void verifySellerName(String sellerName) throws Exception {

		String name = productPageObject.getProductSellerName();

		if (name.equalsIgnoreCase(sellerName)) {

		} else {

		}

	}

	void verifyWarrantyDetails(String warrantyDetails) throws Exception {

		String name = productPageObject.getProductWarrantyDetails();

		if (name.equalsIgnoreCase(warrantyDetails)) {

		} else {

		}

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to add a item into cart by
	 * clicking "Add to Cart" button. Parameter : NIL Created On : 29th Sept 2021
	 * Updated On : 30th Sept 2021
	 */
	public void addToCart() throws Exception {

		productPageObject.clickAddToCartButton();

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to remove a item from cart
	 * based on the product name. Parameter : productName : HP Envy Core i5 10th Gen
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void removeItemFromCart(String productName) {

	}

	public void accesExcelFiles(String excelLocation) throws IOException {

		ArrayList<String> a = new ArrayList<String>();
		externalFunctionObject.excelFileHandling(excelLocation);

	}

	public void verifyPriceInSearchResultsPage(int minPrice, int maxPrice) throws Exception {
		List<WebElement> allProducts = searchResultsPageObject.getSearchResults();

		int flag = 1;
		for (WebElement ele : allProducts) {
			String actualPrice = ele.findElement(By.xpath("a/div/div[contains(text(),'₹')][1]")).getText();
			actualPrice = actualPrice.replace("₹", "");
			actualPrice = actualPrice.replace(",", "");

			int actualPriceInt = Integer.parseInt(actualPrice);
			if (minPrice <= actualPriceInt && maxPrice >= actualPriceInt) {
				continue;
			} else {
				flag = 0;
			}
		}
		if (flag == 1) {
			System.out.println(
					"\nSuccessfully verified the product price & the product price in \"Search Results Page\" is in between "
							+ minPrice + " and " + maxPrice);
		} else {
			System.out.println("The product price in the search results page is not in between given price range");
		}

	}

	static int qtyOfProductInt;

	public void increaseNumberofItemsInCart(String productName) throws Exception {

		String qtyOfProduct = checkoutPageObject.getQuantityOfProduct(productName);
		qtyOfProductInt = Integer.parseInt(qtyOfProduct);

		checkoutPageObject.increaseTheProductCount(productName);

	}

	public void verifyPoductTotalPrice(String productName) throws Exception {
		String price = checkoutPageObject.getPriceOfProduct(productName);
		price = price.replace("₹", "");
		price = price.replace(",", "");
		int priceInt = Integer.parseInt(price);

		String qtyOfProduct = checkoutPageObject.getQuantityOfProduct(productName);
		int qtyOfProductInt = Integer.parseInt(qtyOfProduct);

		if (priceInt == (qtyOfProductInt * productPriceInt)) {

			System.out.println("\nTotal product price verified successfully and is : " + priceInt);

		} else {
			System.out.println("\nTotal product price cannot be verified\nPlease try again");
		}

	}

	public void verifyCartNumber() throws Exception {
		seleniumCommands.closeCurrentWindow();
		seleniumCommands.switchToWindow(parentWindow);
		seleniumCommands.refreshWindow();
		int num = getCartNumber();
		if (currentCartNumber == (num - 1)) {
			System.out.println("\nThe number of items in cart is successfully and the number of items is : " + num);
		} else {
			System.out.println("\nThe number of items in the cart cannot be verified");
		}
	}

	public void verifyProductCount(String productName) throws Exception {
		String qtyOfProduct = checkoutPageObject.getQuantityOfProduct(productName);
		int tempQtyOfProduct = Integer.parseInt(qtyOfProduct);

		if (qtyOfProductInt == (tempQtyOfProduct - 1)) {
			System.out.println("\nThe Product quantity " + tempQtyOfProduct
					+ " is successfully verifed for the product " + productName);
		} else {
			System.out.println("\nThe Product quantity in the cart cannot be verified");
		}

	}

	public void verifyProductNameCheckoutPage(String productName) throws Exception {
		WebElement ele = checkoutPageObject.getProductName(productName);

		if (ele == null) {
			System.out.println(
					"\nCouldn't verify the product name on \"Checkout Page\" \nThe product name doesnot match the given product name : "
							+ productName);
		} else {
			System.out.println("\nSuccessfully verified the product name : " + productName + " on \"Checkout Page\"");
		}

	}

}

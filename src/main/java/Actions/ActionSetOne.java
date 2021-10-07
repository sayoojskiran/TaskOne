package Actions;

import java.io.IOException;
import java.util.ArrayList;

import ExternalFileFunctions.ExternalFunctions;
import PageObjects.*;
import SeleniumCoreFunctions.SeleniumCommands;

public class ActionSetOne {

	SeleniumCommands seliniumCommands = new SeleniumCommands();
	HomePage homePageObject = new HomePage();
	SearchResultsPage searchResultsPageObject = new SearchResultsPage();
	FilterPage filterPageObject = new FilterPage();
	ProductPage productPageObject = new ProductPage();
	ExternalFunctions externalFunctionObject = new ExternalFunctions();

	public void openUrl(String url) throws Exception {

		seliniumCommands.init(url);
		homePageObject.clickOnCloseLogin();

	}

	public void clean() {

		seliniumCommands.cleanUp();

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

		homePageObject.clickOnHomeButton();
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

		boolean rslt = filterPageObject.isBrandExpanded(brandName);
		if (rslt) {
			filterPageObject.clickOnBrandName(brandName);
		} else {
			filterPageObject.clickOnBrandFilter();
			filterPageObject.clickOnBrandName(brandName);
		}

	}
	String filterAppliedXpath = "//*[text()='Filters']/ancestor::section//*[text()='{brand}']";
	public void verifyFilterApplied(String filter)
	{
		if(filterPageObject.getFilterStatus(filterAppliedXpath.replace("{brand}", filter), "Xpath"))
		{
			System.out.println("Successfully verified the filter is applied. Applied Filter : " + filter );
		}
		else
		{
			System.out.println("Could not apply the filter. Filter to be applied: " + filter);
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
	void selectRamSizeFilter(String ramSize) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to select "Storage Size"
	 * of the product. Eg: Storage Size -> 512 GB Parameter : storageSize : 512 GB
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void selectStorageSizeFilter(String storageSize) {

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to click on "Product"
	 * based on product name. Eg: Product Name -> HP Envy Core i5 10th Gen Parameter
	 * : productName : HP Envy Core i5 10th Gen Created On : 29th Sept 2021 Updated
	 * On : 30th Sept 2021
	 */
	public void selectProduct(String productName) throws Exception {

		searchResultsPageObject.clickProduct(productName);

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
	void verifyProductName(String productName) {

		// Verify product

	}

	/*
	 * Name : Sayooj S Kiran Description : This method is to verify the existing
	 * product price with the given product price. Eg: Given Product Price ->
	 * ₹78,990 Existing Product Price -> ₹78,990 Parameter : productPrice : ₹78,990
	 * Created On : 29th Sept 2021 Updated On : 30th Sept 2021
	 */
	void verifyProductPrice(String productPrice) {

		// Verify price

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

}

package Tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Actions.ActionSetOne;

public class ScenarioOne {
	ActionSetOne testActions = new ActionSetOne();

	String url = "https://www.flipkart.com/";
	String excelLocation = "C:\\Users\\DarKLorD\\Desktop\\Book2.xlsx";

	@Test
	public void testNew() throws Exception {

		testActions.openUrl(url);
		testActions.selectCategory("Electronics", "Laptops", "Gaming Laptops");
//		testActions.selectSortMethod("Price -- Low to High");
		testActions.selectMinMaxPriceFilter("30000", "40000", "Xpath");
		testActions.selectBrandFilter("HP");
		testActions.verifyFilterApplied("₹30000-₹40000");
		//Thread.sleep(1000);
		testActions.verifyFilterApplied("HP");
		testActions.selectProduct("HP Ryzen 3 Dual Core 3250U - (8 GB/256 GB SSD/Windows 1...");
		testActions.addToCart();	
		
//		testActions.accesExcelFiles(excelLocation);

	}
	@AfterTest
	void cleanUp()
	{
		testActions.clean();
	}

}

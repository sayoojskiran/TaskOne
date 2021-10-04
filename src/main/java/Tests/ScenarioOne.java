package Tests;

import org.testng.annotations.Test;

import Actions.ActionSetOne;

public class ScenarioOne {
	ActionSetOne testActions = new ActionSetOne();

	String url = "https://www.flipkart.com/";

	@Test
	public void testNew() throws Exception {

		testActions.openUrl(url);
		testActions.selectCategory("Electronics", "Laptops", "Gaming Laptops");
//		testActions.selectSortMethod("Price -- Low to High");
		testActions.selectMinMaxPriceFilter("30000", "40000", "Xpath");
//		testActions.clean();

	}

}

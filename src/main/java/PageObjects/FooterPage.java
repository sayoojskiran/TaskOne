package PageObjects;

import SeleniumCoreFunctions.SeleniumCommands;

public class FooterPage {

	SeleniumCommands seleniumCommands = new SeleniumCommands();
	
	String aboutUsXpath = "//a[text()='About Us']";
	String onCareersXpath = "//a[text()='Careers']";
	String contactUsXpath = "//a[text()='Contact Us']";
	

	public void clickOnContactUs() throws Exception {

		seleniumCommands.click("Contact Us", "LinkText");

	}

	public void clickOnAboutUs() {

	}

	public void clickOnCareers() {

	}

	public void clickOnPayment() {

	}

	public void clickOnShipping() {

	}

	public void clickOnFAQ() {

	}

}

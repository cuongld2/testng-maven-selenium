package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.*;

public class ElementTest extends BasePage{


	@BeforeMethod()
	public void navigateToElementsPage(){
		HomePage homePage = new HomePage(driver);
		homePage.navigateToElementsPage();
	}

	@DataProvider(name = "text-box")
	public Object[][] textBox(){
		return new Object[][] {{"teaha", "lhfahfas2@gmail.com" , "ahafasg","fhahafhas"}, {"teaha", "test@gmail.com" , "justTest","fhahafhas"},
				{"teaha", "" , "ahafasg","fhahafhas"}, {"teaha", "test@gmail.com" , "","fhahafhas"}, {"teaha", "" , "",""}};
	}

	@Test(priority=0,dataProvider = "text-box")
	public void interactWithTextBox(String fullName, String email, String currentAddress, String permanentAddress) {
		ElementPage elementPage = new ElementPage(driver);
		elementPage.chooseTextBoxElement();
		elementPage.submitTextBox(fullName,email,currentAddress,permanentAddress);
		elementPage.verifyResult(fullName,email,currentAddress,permanentAddress);
	}

}

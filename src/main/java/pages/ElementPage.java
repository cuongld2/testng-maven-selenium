package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import static org.testng.Assert.assertTrue;

public class ElementPage {


	By textBoxButton=By.xpath("//span[text()='Text Box']");

	By fullName=By.id("userName");
	By userEmail=By.id("userEmail");

	By currentAddress=By.id("currentAddress");
	By permanentAddress=By.id("permanentAddress");

	By submitButton=By.id("submit");

	By fullNameResult=By.id("name");

	By emailResult=By.id("email");

	By currentAddressResult=By.cssSelector("p[id=\"currentAddress\"]");
	By permanentAddressResult=By.cssSelector("p[id=\"permanentAddress\"]");

	WebDriver driver;
	WebDriverWait wait;
	
	public ElementPage(WebDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 5);
	}

	public void chooseTextBoxElement(){
		driver.findElement(textBoxButton).click();
		driver.navigate().refresh();
	}

	public void submitTextBox(String fullNameText, String userEmailText, String currentAddressText, String permanentAddressText){
		driver.findElement(fullName).sendKeys(fullNameText);
		driver.findElement(userEmail).sendKeys(userEmailText);
		driver.findElement(currentAddress).sendKeys(currentAddressText);
		driver.findElement(permanentAddress).sendKeys(permanentAddressText);
		driver.findElement(submitButton).click();

	}

	public void verifyResult(String fullNameText, String userEmailText, String currentAddressText, String permanentAddressText){

		Map<By, String> map = new HashMap<>();
		map.put(fullNameResult,fullNameText);
		map.put(emailResult,userEmailText);
		map.put(currentAddressResult,currentAddressText);
		map.put(permanentAddressResult,permanentAddressText);
		map.forEach((key,value)->{

			if (Objects.equals(value, "")){
				System.out.printf("%s is blank, so no result here",value);
			}else {
				String resultText = driver.findElement(key).getText();
				assertTrue(resultText.contains(value));
			}

		});



	}


}

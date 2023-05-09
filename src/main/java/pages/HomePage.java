package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }
    By elementsButton=By.xpath("//*[text()='Elements']");

    public void navigateToElementsPage() {
        driver.findElement(elementsButton).click();
    }
}

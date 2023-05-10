package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopUpPage {

    WebDriver driver;
    WebDriverWait wait;

    public PopUpPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, 5);
    }

    public void click(By element, By popup, By popupRemove) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public String getTextElement(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return driver.findElement(element).getText();
    }

    public void visit(String url, By popup, By popupRemove) throws InterruptedException {
        driver.get(url);

        Thread.sleep(1000);

        int i=0;
        int k=0;

        while (i==0 || k<4){

            if (driver.findElements(popup).size()==1){
                driver.findElement(popupRemove).click();
                i++;
            }

            Thread.sleep(1000);
            k++;

        }



    }

}

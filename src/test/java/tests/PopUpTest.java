package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.*;
import pages.PopUpPage;


public class PopUpTest {

    public static WebDriver driver;
    String url = "https://zujukickoff.com/";

    @BeforeMethod()
    public void setup(ITestContext context) {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        context.setAttribute("WebDriver", driver);
    }

    @AfterMethod()
    public void tearDown() {
        driver.quit();
    }



    @Test(priority=0)
    public void testPopUp() throws InterruptedException {
        PopUpPage popUpPage = new PopUpPage(driver);
        By popup= By.cssSelector("div[role=\"dialog\"]");
        By closedButtonPopUp=By.cssSelector("svg[data-testId=\"CloseIcon\"]");

        // Navigate to the home page of zuju
        popUpPage.visit(url,popup,closedButtonPopUp);
        By teamsNavigationButton = By.xpath("//h4[text()='Teams']");

        // Click on the team navigation button
        popUpPage.click(teamsNavigationButton,popup,closedButtonPopUp);


        // Verify if browser successfully navigates to the teams page
        int i =0;
        int k=0;
        while (k<4){
            if (popUpPage.getTextElement(By.cssSelector("h2[class=\"MuiTypography-root MuiTypography-h2 " +
                    "css-5i6lre\"]")).contains("All Teams") && driver.getCurrentUrl().contains("reputation"))
            {
                i++;
                break;

            }
            Thread.sleep(1000);
            k++;

        }
        Assert.assertEquals(i,1,"i should equals 1");

    }
}

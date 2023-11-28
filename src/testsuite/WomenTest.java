package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    /**
     * verifyTheSortByProductNameFilter
     * * Mouse Hover on Women Menu
     * * Mouse Hover on Tops
     * * Click on Jackets
     * * Select Sort By filter “Product Name”
     * * Verify the products name display in
     * alphabetical order
     */
    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        mouseHoverToElement(By.id("ui-id-4"));
        mouseHoverToElement(By.id("ui-id-9"));
        clickOnElement(By.id("ui-id-11"));
        Thread.sleep(2000);
        selectByVisibleText(By.xpath("//select[@id='sorter']"), "Product Name ");

        List<WebElement> element1 = driver.findElements(By.xpath("//strong[@class = 'product name product-item-name']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }


    /**
     * verifyTheSortByPriceFilter
     * * Mouse Hover on Women Menu
     * * Mouse Hover on Tops
     * * Click on Jackets
     * * Select Sort By filter “Price”
     * * Verify the products price display in
     * Low to High
     */
    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        mouseHoverToElement(By.id("ui-id-4"));
        mouseHoverToElement(By.id("ui-id-9"));
        clickOnElement(By.id("ui-id-11"));
        Thread.sleep(2000);
        selectByVisibleText(By.xpath("//select[@id='sorter']"), "Price ");

        List<WebElement> element1 = driver.findElements(By.xpath("//div[@class='price-box price-final_price']"));
        for (WebElement result : element1) {
            System.out.println(result.getText());
        }
    }

    @After
    public void setDown() {
        closeBrowser();
    }
}



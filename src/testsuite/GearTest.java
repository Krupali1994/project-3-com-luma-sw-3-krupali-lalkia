package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class GearTest extends Utility {

    /**
     * 6.Write down the following test into ‘GearTest’ class
     * ShoppinCart()
     * * Mouse Hover on Gear Menu
     * * Click on Bags
     * * Click on Product Name ‘Overnight Duffle’
     * * Verify the text ‘Overnight Duffle’
     * * Change Qty 3
     * * Click on ‘Add to Cart’ Button.
     * * Verify the text
     * ‘You added Overnight Duffle to your shopping cart.’
     * * Click on ‘shopping cart’ Link into
     * message
     * * Verify the product name ‘Cronus Yoga Pant’
     * * Verify the Qty is ‘3’
     * * Verify the product price ‘$135.00’
     * * Change Qty to ‘5’
     * * Click on ‘Update Shopping Cart’ button
     * * Verify the product price ‘$225.00’
     */
    static String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        Thread.sleep(500);
        mouseHoverToElement(By.cssSelector("#ui-id-6"));

        Thread.sleep(500);
        clickOnElement(By.xpath("(//a[@id='ui-id-25'])[1]"));

        clickOnElement(By.xpath("//a[normalize-space()='Overnight Duffle']"));

        Thread.sleep(500);
        String expected = "Overnight Duffle";
        String actual = getTextFromElement(By.cssSelector(".base"));
        assertEqualsMethod("Text is not matched", expected, actual);

        Thread.sleep(1000);
        clearTextField(By.id("qty"));
        sendTextToElement(By.id("qty"), "3");

        clickOnElement(By.xpath("//button[@id='product-addtocart-button']"));

        Thread.sleep(500);
        String expectedText = "You added Overnight Duffle to your shopping cart.";
        String actualText = getTextFromElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        assertEqualsMethod("Text is not matched", expectedText, actualText);

        Thread.sleep(500);
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        Thread.sleep(500);
        String expectedName = "Overnight Duffle";
        String actualName = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Overnight Duffle']"));
        assertEqualsMethod("Name is not matched", expectedName, actualName);

        Thread.sleep(1000);
        String expectedQty = "3";
        String actualQty = getTextFromElement(By.xpath("//span[@class='counter-number']"));
        assertEqualsMethod("Qty is not matched", expectedQty, actualQty);

        Thread.sleep(500);
        String expectedPrice = "$135.00";
        String actualPrice = getTextFromElement(By.cssSelector("td[class='col subtotal'] span[class='price']"));
        assertEqualsMethod("Price is not matched", expectedPrice, actualPrice);

        Thread.sleep(1000);
        clearTextField(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"));
        sendTextToElement(By.xpath("//td[@class='col qty']/child::div[1]/descendant::input"), "5");

        clickOnElement(By.xpath("//button[@title='Update Shopping Cart']"));

        Thread.sleep(500);
        String expectedAmount = "$225.00";
        String actualAmount = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        assertEqualsMethod("Price is not matched", expectedAmount, actualAmount);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

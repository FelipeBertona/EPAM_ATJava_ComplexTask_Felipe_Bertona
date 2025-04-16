package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the Inventory Page of the SauceDemo web application.
 * Provides methods to interact with and retrieve information from the inventory page.
 * Extends the {@link AbstractPage} and implements the required page-opening behavior.
 */
public class InventoryPage extends AbstractPage {

    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);

    /**
     * The URL for the Inventory Page.
     */
    private final String PAGE_URL = "https://www.saucedemo.com/inventory.html";

    /**
     * WebElement representing the logo or title on the Inventory Page.
     */
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement inventoryPage;

    /**
     * Constructs an InventoryPage object and initializes its elements using Selenium's PageFactory.
     *
     * @param driver the WebDriver instance used to interact with the browser
     */
    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
        logger.info("InventoryPage initialized");
    }

    /**
     * Opens the Inventory Page.
     *
     * @return the current instance of {@link InventoryPage}
     */
    @Override
    public InventoryPage openPage() {
        logger.info("Navigating to URL: " + PAGE_URL);
        driver.get(PAGE_URL);
        return this;
    }

    /**
     * Retrieves the title or text displayed on the Inventory Page.
     *
     * @return a string representing the title on the inventory page
     */
    public String getTitle() {
        String title = inventoryPage.getText();
        logger.info("Captured InventoryPage title: {}", title);
        return title;
    }
}
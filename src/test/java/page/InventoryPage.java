package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents the Inventory Page of the SauceDemo web application.
 * Provides methods to interact with and retrieve information from the inventory page.
 * Extends the {@link BasePage} and implements the required page-opening behavior.
 */
public class InventoryPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);

    /**
     * WebElement representing the logo or title on the Inventory Page.
     */
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement inventoryPage;

    /**
     * Constructs an InventoryPage object and initializes its elements using Selenium's PageFactory.
     */
    public InventoryPage() {
        super();
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
        logger.info("Navigating to URL: " + BASE_URL + "inventory.html");
        driver.get(BASE_URL + "inventory.html");
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
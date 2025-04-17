package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Inventory Page of the SauceDemo application.
 * Displayed after successful login.
 */
public class InventoryPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement inventoryPage;

    public InventoryPage() {
        super();
        PageFactory.initElements(this.driver, this);
        logger.info("InventoryPage initialized");
    }

    @Override
    public InventoryPage openPage() {
        logger.info("Navigating to URL: " + BASE_URL + "inventory.html");
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    public String getTitle() {
        String title = inventoryPage.getText();
        logger.info("Captured InventoryPage title: {}", title);
        return title;
    }
}
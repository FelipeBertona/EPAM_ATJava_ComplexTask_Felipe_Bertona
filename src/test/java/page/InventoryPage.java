package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * Inventory Page of the SauceDemo application.
 * Displayed after successful login.
 */
public class InventoryPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(InventoryPage.class);

    public InventoryPage() {
        super();
        logger.info("InventoryPage initialized");
    }

    @Override
    public InventoryPage openPage() {
        logger.info("Navigating to URL: " + BASE_URL + "inventory.html");
        driver.get(BASE_URL + "inventory.html");
        return this;
    }

    public String getTitle() {
        try {
            WebElement banner = new WebDriverWait(this.driver, Duration.of(this.WAIT_TIMEOUT_SECONDS, ChronoUnit.SECONDS))
                    .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='app_logo']"))));

            String title = banner.getText();

            logger.info("Captured InventoryPage title: {}", title);
            return title;
        } catch (NoSuchElementException e) {
            logger.error("Failed to locate topBanner element. Likely not on InventoryPage. Exception: {}", e.getMessage());
            return "Login Failed: Still on Login Page";
        }
    }
}
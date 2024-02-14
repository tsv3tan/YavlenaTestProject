package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='field search-field']//input)[1]")
    WebElement brokerSearchInputField;

    @FindBy(xpath = "//div[@class='position']/a")
    WebElement brokerAddress;

    @FindBy(xpath = "//span[@class='icon-briefcase']/following-sibling::a")
    WebElement brokerPropertiesNumber;

    @FindBy(xpath = "(//div[@class='tel-group']//a)[1]")
    WebElement brokerLandLineNumber;

    @FindBy(xpath = "(//div[@class='tel-group']//a)[2]")
    WebElement brokerMobileNumber;


    public boolean verifyBrokerDetails(List<String> storedNames) {
        boolean isDisplayed = true;
        for (String storedName : storedNames) {
            brokerSearchInputField.clear();
            brokerSearchInputField.sendKeys(storedName);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.
                    visibilityOfElementLocated(By.xpath("(//div[@style='display: block;'])[1]")));
            wait.until(ExpectedConditions.
                    invisibilityOfElementLocated(By.xpath("(//div[@style='display: block;'])[1]")));
            List<WebElement> brokerNames =
                    driver.findElements(By.xpath("//div[@class='broker-data']//h3/a"));
            for (WebElement brokerName : brokerNames) {
                if (!brokerName.getText().equals(storedName) || !brokerName.isDisplayed() || !isAddressDisplayed()
                        || !isPropertiesDisplayed() || !isLandLineNumberDisplayed() || !isMobileDisplayed()) {
                    isDisplayed = false;
                    break;
                }
            }
            if (!isDisplayed) {
                break;
            }
        }
        return isDisplayed;
    }


    public boolean isAddressDisplayed() {
        try {
            return brokerAddress.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isPropertiesDisplayed() {
        try {
            return brokerPropertiesNumber.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isMobileDisplayed() {
        try {
            return brokerMobileNumber.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public boolean isLandLineNumberDisplayed() {
        try {
            return brokerLandLineNumber.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
}


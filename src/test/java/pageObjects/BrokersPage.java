package pageObjects;

import Helper.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class BrokersPage {

    private WebDriver driver;

    public BrokersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='load-more-brokers']//a")
    WebElement loadMoreButton;

    @FindBy(xpath = "//form[@class='cookie-message-form']/input")
    WebElement cookieSubmitButton;

    public void navigateToMainPage() {
        driver.navigate().to(Helper.BASE_URL);
    }

    public void clicksToLoadMoreBrokerButton() {
        loadMoreButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By gridHolder = By.xpath("//div[@id='brokers-grid-holder']/following-sibling::div[@style='display: none;']");
        wait.until(ExpectedConditions.presenceOfElementLocated(gridHolder));
    }

    public void acceptCookiesForm() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        By gridHolder = By.xpath("//form[@class='cookie-message-form']/input");
        wait.until(ExpectedConditions.presenceOfElementLocated(gridHolder));
        cookieSubmitButton.click();
    }

    public List<String> storeAllTheBrokersNames() {
        List<String> brokersNames = new ArrayList<>();
        List<WebElement> allBrokersNames = driver.findElements(By.xpath("//div[@class='broker-data']//h3/a"));
        for (WebElement brokerName : allBrokersNames) {
            brokersNames.add(brokerName.getText());
        }
        return brokersNames;
    }
}

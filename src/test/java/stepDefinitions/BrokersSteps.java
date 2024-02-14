package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pageObjects.BrokersPage;

import java.nio.file.FileSystems;
import java.util.List;

import org.testng.Assert;
import pageObjects.SearchPage;

public class BrokersSteps {
    private static WebDriver driver;
    private static final String userDir = System.getProperty("user.dir");
    public List<String> storedNames;
    BrokersPage brokersPage = new BrokersPage(driver);
    SearchPage searchPage = new SearchPage(driver);


    @BeforeAll
    public static void driverSetUp() {
        String pathSeparator = FileSystems.getDefault().getSeparator();
        String userDir = System.getProperty("user.dir");
        System.setProperty("webdriver.edge.driver", userDir + pathSeparator + "drivers" + pathSeparator + "msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Given("User navigates to the brokers page and accept cookies form")
    public void userNavigatesToTheBrokersPageAndAcceptCookiesForm() {
        brokersPage.navigateToMainPage();
        brokersPage.acceptCookiesForm();
    }

    @When("user clicks to load more brokers button")
    public void userClicksToLoadMoreBrokersButton() {
        brokersPage.clicksToLoadMoreBrokerButton();
    }

    @And("user stores all the brokers names")
    public void userStoresAllTheBrokersNames() {
        storedNames = brokersPage.storeAllTheBrokersNames();
    }

    @Then("user verifies broker name, address, properties and phone are visible")
    public void userVerifiesBrokerNameAddressPropertiesAndPhoneVisabillity() {
        Assert.assertTrue(searchPage.verifyBrokerDetails(storedNames));
    }
}

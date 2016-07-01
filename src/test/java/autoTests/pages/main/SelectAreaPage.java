package autoTests.pages.main;

import autoTests.ConfigurationVariables;
import autoTests.CustomMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Slame on 24.02.16.
 */
public class SelectAreaPage extends CustomMethods {
    WebDriver driver;
    ConfigurationVariables configVariables = ConfigurationVariables.getInstance();
    // Variables

    @FindBy(xpath = "//div[@class='service-name ng-binding']")
    public WebElement serviceName;      // название услуги

//    @FindBy(css = "button.btn.btn-default")
    @FindBy(id = "region")
    public WebElement regions;         // выпадающий список региона

    @FindBy(xpath = "//label[@for='region']")
    public WebElement region;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement cities;          // выпадающий список города

    @FindBy(xpath = "//span[@class=\"input-group-btn\"]")
    private WebElement regionsButton;

    // Methods

    public SelectAreaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Method for selection of Region
    public void selectRegion(String region) throws Exception {
        waitForElementPresent(driver, regionsButton, 5, 1000);
        regionsButton.click();
        driver.findElement(By.xpath("//a[contains(text(),'" + region + "')]")).click();
    }

    // Method for selection of City
    public void selectCity(String city) {
        cities.click();
        driver.findElement(By.linkText(city)).click();
    }

    // Method for selection of service tab
    public void clickServiceTab(String serviceTab) {
        driver.findElement(By.xpath("//a[contains(.,'" + serviceTab + "')]")).click();
    }

    // Method for opening Statistic tab
    public void openStatisticTab() {

        driver.findElement(By.xpath("//a[text()='Статистика']")).click();
    }

    public String getServiceNameText() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.stalenessOf(serviceName));
        wait.until(ExpectedConditions.visibilityOf(serviceName));
        return serviceName.getText();
    }
}

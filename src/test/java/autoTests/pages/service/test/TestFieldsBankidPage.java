package autoTests.pages.service.test;

import autoTests.ConfigurationVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import autoTests.pages.service.BaseServicePage;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class TestFieldsBankidPage extends BaseServicePage {
    WebDriver driver;
    ConfigurationVariables configVariables = ConfigurationVariables.getInstance();
    public static String referenceNumber;

    //---------------- Элементы страницы------------------// 
    @FindBy(name = "bankIdsID_Country")
    private WebElement countryField; // поле ввода гражданства

    @FindBy(name = "bankIdAddressFactual")
    private WebElement addressField; // поле ввода адреса прописки

    @FindBy(xpath = "(//input[@type='file'])[1]")
    public WebElement attachDocumentButton; // поле аттача

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(xpath = "//div[@class='text-center ng-binding ng-scope']")
    private WebElement successText; //текст удачной создании заявки

    public TestFieldsBankidPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    private static void setClipboardData(String document) {
        StringSelection stringSelection = new StringSelection(document);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    //---------------- Методы ввода данных в поля------------------//
    public TestFieldsBankidPage typeInCountryField(String country) {
        countryField.clear();
        countryField.sendKeys(country); // ввод гражданства
        return this;
    }

    public TestFieldsBankidPage typeInAddressField(String address) {
        addressField.clear();
        addressField.sendKeys(address); // ввод адреса прописки
        return this;
    }

    public TestFieldsBankidPage typeInEmailField(String email){
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    @Override
    public TestFieldsBankidPage clickConfirmButton() {
        super.clickConfirmButton();
        return this;
    }

    public TestFieldsBankidPage verifyServiceSuccessCreated(String email) {
        Assert.assertEquals(successText.getText(), "Результати будуть спрямовані на Ваш e-mail " + email);// проверка успешного создания заявки
        return this;
    }
//=================методы по работе с номером заявки=======================//

    @Override
    public String saveReferenceNumber() {
        referenceNumber = super.saveReferenceNumber();
        return referenceNumber;
    }
}

package autoTests.pages.service.authorities.interaction;


import autoTests.ConfigurationVariables;
import autoTests.CustomMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import autoTests.pages.service.BaseServicePage;

public class LandSizeAndExistencePage extends BaseServicePage {
    WebDriver driver;
    ConfigurationVariables configVariables = ConfigurationVariables.getInstance();
    CustomMethods customMethods = new CustomMethods();

    public static String referenceNumber;

    @FindBy(name = "organ")
    private WebElement districtOrCityDropDown;

    @FindBy(name = "bankIdAddressFactual")
    private WebElement homeAddressField;

    @FindBy(name = "pidstavi")
    private WebElement applicantDropDown;

    @FindBy(name = "landAddress")
    private WebElement landAddressField;

    @FindBy(name = "landNumb")
    private WebElement landRegistrationNumberField;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    private WebElement attachDocumentButton;

    public LandSizeAndExistencePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public LandSizeAndExistencePage selectDistrict(String district) {
        districtOrCityDropDown.sendKeys(district + '\n');
        return this;
    }

    public LandSizeAndExistencePage enterAddress(String address) {
        homeAddressField.sendKeys(address);
        return this;
    }

    public LandSizeAndExistencePage typeInPhoneField(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone);
        return this;
    }

    public LandSizeAndExistencePage typeInEmailField(String email) {
        emailField.sendKeys(email); //email
        return this;
    }

    public LandSizeAndExistencePage selectApplicant(String applicant) {
        new Select(applicantDropDown).selectByVisibleText(applicant);
        return this;
    }

    public LandSizeAndExistencePage attachFile(String filePath) {
        customMethods.attachDocument(attachDocumentButton, filePath, driver);
        return this;
    }

    @Override
    public LandSizeAndExistencePage clickConfirmButton() {
        super.clickConfirmButton();
        return this;
    }

    public LandSizeAndExistencePage verifyServiceSuccessCreated() {
        successText.isDisplayed();// проверка успешного создания заявки
        return this;
    }

    public LandSizeAndExistencePage typeInLandAddressField(String landAddress) {
        landAddressField.sendKeys(landAddress);
        return this;
    }

    public LandSizeAndExistencePage typeInLandRegisterNumberField(String landRegisterNumber) {
        landRegistrationNumberField.sendKeys(landRegisterNumber);
        return this;
    }

    @Override
    public String saveReferenceNumber() {
        referenceNumber = super.saveReferenceNumber();
        return referenceNumber;
    }
}

package autoTests.pages.service.taxes;

import autoTests.ConfigurationVariables;
import autoTests.CustomMethods;
import autoTests.pages.service.BaseServicePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;

/**
 * Created by Slame on 25.02.2016.
 */
public class CertificateFromUnifiedRegisterPage extends BaseServicePage {
	WebDriver driver;
	ConfigurationVariables configVariables = ConfigurationVariables.getInstance();
	CustomMethods customMethods = new CustomMethods();

	@FindBy(xpath = "//div[@on='property.type']/input[@name='bankIdfirstName']")
	private WebElement referentFirstNameField;

	@FindBy(xpath = "//div[@on='property.type']/input[@name='bankIdlastName']")
	private WebElement referentLastNameField;

	@FindBy(xpath = "//div[@on='property.type']/input[@name='bankIdmiddleName']")
	private WebElement referentMiddleNameField;

	@FindBy(xpath = "//div[@on='property.type']/input[@name='bankIdPassport']")
	private WebElement referentPassportField;

	@FindBy(xpath = "//div[@on='property.type']/input[@name='bankIdinn']")
	private WebElement referentIPNCodeField;

	@FindBy(xpath = "//select[@name='area']")
	private WebElement fiscalBranchDropDown;

	@FindBy(xpath = "//select[@name='subekt']")
	private WebElement subjectCertificateDropDown;

	@FindBy(xpath = "//input[@name='nomer']")
	private WebElement edrpouORIpnField;

	@FindBy(xpath = "//input[@name='naimenov']")
	private WebElement companyNameField;

	@FindBy(xpath = "//input[@name='organ']")
	private WebElement reasonForCertificateField;

	@FindBy(xpath = "(//input[@type='file'])")
	private WebElement attachDocumentButton;

	@FindBy(xpath = "//label[normalize-space(text())='Заповнення референтом']")
	private WebElement fillByReferentLabel;

	public CertificateFromUnifiedRegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}


	public CertificateFromUnifiedRegisterPage typeInEmailField(String email) {
		emailField.sendKeys(email);
		return this;
	}

	public CertificateFromUnifiedRegisterPage selectFiscalBranchField(String fiscalBranch) {
		new Select(fiscalBranchDropDown).selectByVisibleText(fiscalBranch);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInFirstNameField(String firstName) {
		referentFirstNameField.clear();
		referentFirstNameField.sendKeys(firstName);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInLastNameField(String lastName) {
		referentLastNameField.clear();
		referentLastNameField.sendKeys(lastName);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInMiddleNameField(String middleName) {
		referentMiddleNameField.clear();
		referentMiddleNameField.sendKeys(middleName);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInPassportField(String passport) {
		referentPassportField.clear();
		referentPassportField.sendKeys(passport);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInIPNField(String ipnCode) {
		referentIPNCodeField.clear();
		referentIPNCodeField.sendKeys(ipnCode);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInPhoneField(String phone) {
		phoneField.clear();
		phoneField.sendKeys(phone);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInEdrpouORIpnField(String edrpouOrIpn) {
		edrpouORIpnField.clear();
		edrpouORIpnField.sendKeys(edrpouOrIpn);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInCompanyNameField(String companyName) {
		companyNameField.clear();
		companyNameField.sendKeys(companyName);
		return this;
	}

	public CertificateFromUnifiedRegisterPage clickOnFillByReferentField(){
		fillByReferentLabel.click();
		return this;
	}

	public CertificateFromUnifiedRegisterPage selectCertificateSubject(String certificateSubject) {
		new Select(subjectCertificateDropDown).selectByVisibleText(certificateSubject);
		return this;
	}

	public CertificateFromUnifiedRegisterPage typeInReasonForCertificateField(String reasonForCertificate) {
		reasonForCertificateField.clear();
		reasonForCertificateField.sendKeys(reasonForCertificate);
		return this;
	}

	public CertificateFromUnifiedRegisterPage attachFile(String filePath) {
		customMethods.attachDocument(attachDocumentButton, filePath, driver);
		return this;
	}

	public CertificateFromUnifiedRegisterPage verifyServiceSuccessCreated() {
		assertTrue(successText.isDisplayed(), "Success text is not present");
		return this;
	}

	@Override
	public String saveReferenceNumber() {
		return super.saveReferenceNumber();
	}

	@Override
	public CertificateFromUnifiedRegisterPage clickConfirmButton() {
		super.clickConfirmButton();
		return this;
	}
}

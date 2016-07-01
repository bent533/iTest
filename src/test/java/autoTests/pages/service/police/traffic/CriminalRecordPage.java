package autoTests.pages.service.police.traffic;

import autoTests.ConfigurationVariables;
import org.omg.CORBA.StringHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import autoTests.pages.service.BaseServicePage;

import java.awt.image.CropImageFilter;

public class CriminalRecordPage extends BaseServicePage {
    WebDriver driver;
    ConfigurationVariables configVariables = ConfigurationVariables.getInstance();
    public static String referenceNumber;

    //---------------- Элементы страницы------------------//
    @FindBy(name = "sFamily_RU")
    private WebElement lastNameRusField;                    // поле ввода фамилии рус

    @FindBy(name = "sName_RU")
    private WebElement nameRusField;                        // поле ввода имени рус

    @FindBy(name = "sSurname_RU")
    private WebElement middleNameRusField;                  //поле ввода отчества рус

    @FindBy(name = "missprint")
    private WebElement mistakeInFioDropdown;                //дропдаун Ошибка в ФИО

    @FindBy(name = "text1")
    private WebElement changesInNameDropdown;               //дропдаун изменения ФИО

    @FindBy(name = "Sex")
    private WebElement sexDropdown;                         //дропдаун Пола

    @FindBy(xpath = "(//div[@class='ui-select-match'])[1]")
    private WebElement citizenshipDropdown;                 //dropdown гражданства

    @FindBy(xpath = "(//div[@class='ui-select-match'])[2]")
    private  WebElement countryOfBirthDropDown;             //dropdown країна народження

    @FindBy(name = "sPlace")
    private WebElement cityOfBirthField;                    //город рождения

    @FindBy(name = "goal")
    private WebElement goalField;                           // поле цели получения документа

    @FindBy(name = "phone")
    private WebElement phoneField;                          // поле ввода телефона

    @FindBy(name = "email")
    private WebElement emailField;                          //поле эмейла

    private static final String COUNTRY_LOCATOR = "//span[@title='%s']";





    @FindBy(name = "birthDate")
    private WebElement birthDateField; // поле даты рождения

    @FindBy(name = "birthLoc")
    private WebElement birthLocField; // поле места рождения

    @FindBy(name = "res_type")
    private WebElement resTypeField; // поле результата оработки обращения

    @FindBy(xpath = "//div[@class='text-center ng-binding ng-scope']")
    private WebElement successText; //текст удачной создании заявки



    public CriminalRecordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //---------------- Методы ввода данных в поля------------------//

    // Method for typing in Last Name Rus
    public CriminalRecordPage typeInLastNameRus(String lastName){
        lastNameRusField.sendKeys(lastName);
        return this;
    }

    //Method for typing in Name Rus
    public CriminalRecordPage typeInNamerus(String nameRus){
        nameRusField.sendKeys(nameRus);
        return this;
    }

    //Method for typing in Middle Name Rus
    public CriminalRecordPage typeInMiddleNameRus(String middleName){
        middleNameRusField.sendKeys(middleName);
        return this;
    }

    //Method for selecting No Mistakes in Name, Last and Middle
    public CriminalRecordPage selectNoMistakesDropDown(String answer){
        Select dropdown = new Select(mistakeInFioDropdown);
        dropdown.selectByVisibleText(answer);
        return this;
    }

    //Method for selecting Didn't changed Name, Last and Middle
    public CriminalRecordPage selectDidntChangedName(String answer){
        Select dropdown = new Select(changesInNameDropdown);
        dropdown.selectByVisibleText(answer);
        return this;
    }

    //Method for selecting Sex
    public CriminalRecordPage selectSex(String sex){
        Select dropdown = new Select(sexDropdown);
        dropdown.selectByVisibleText(sex);
        return this;
    }

    //Method for selecting Citizenship
    public CriminalRecordPage selectCitizenship(String country) throws InterruptedException {
        citizenshipDropdown.click();
        driver.findElement(By.xpath(String.format(COUNTRY_LOCATOR, country))).click();
        return this;
    }

    //Method for selecting Country
    public CriminalRecordPage selectCountryOfBirth(String country){
        countryOfBirthDropDown.click();
        driver.findElement(By.xpath(String.format(COUNTRY_LOCATOR, country))).click();
        return this;
    }

    //Method for typing in city of birth
    public  CriminalRecordPage typeInCityOfBirth(String city){
        cityOfBirthField.sendKeys(city);
        return this;
    }

    public CriminalRecordPage selectGoal(String goal) {
        new Select(goalField).selectByVisibleText(goal);  //выбор цели получения документа
        return this;
    }

    public CriminalRecordPage typeInPhoneField(String phone) {
        phoneField.clear();
        phoneField.sendKeys(phone); // ввод телефона
        return this;
    }

    public CriminalRecordPage typeInEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email); // ввод емайла
        return this;
    }

    @Override
    public CriminalRecordPage clickConfirmButton() {
        super.clickConfirmButton();
        return this;
    }


    public CriminalRecordPage verifyServiceSuccessCreated() {
        successText.isDisplayed();// проверка успешного создания заявки
        return this;
    }

//=================методы по работе с номером заявки=======================//

    @Override
    public String saveReferenceNumber() {
        referenceNumber = super.saveReferenceNumber();
        return referenceNumber;
    }
}

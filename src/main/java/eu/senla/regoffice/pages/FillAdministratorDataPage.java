package eu.senla.regoffice.pages;

import eu.senla.regoffice.models.AdminRegistrationDataDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class FillAdministratorDataPage extends BasePage {

    public FillAdministratorDataPage(WebDriver driver) {
        super(driver);
    }

    private final By lastNameInput = By.id("TextInputField-1");
    private final By firstNameInput = By.id("TextInputField-2");
    private final By middleNameInput = By.id("TextInputField-3");
    private final By phoneNumberInput = By.cssSelector("[type='phone']");
    private final By passportInput = By.id("TextInputField-5");
    private final By birthdayInput = By.cssSelector("[type='date']");
    private final By nextBtn = By.xpath("//*[text()='Далее']");

    public void fillRegistrationData(AdminRegistrationDataDto data) {
        fillLastNameInput(data.lastName());
        fillFirstNameInput(data.firstName());
        fillMiddleNameInput(data.middleName());
        fillPhoneNumberInput(data.phone());
        fillPassportInput(data.passport());
        fillBirthdayInput(data.birthday());
    }

    public void fillLastNameInput(String lastName) {
        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void fillFirstNameInput(String firstName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void fillMiddleNameInput(String middleName) {
        driver.findElement(middleNameInput).sendKeys(middleName);
    }

    public void fillPhoneNumberInput(String phone) {
        driver.findElement(phoneNumberInput).sendKeys(phone);
    }

    public void fillPassportInput(String passport) {
        driver.findElement(passportInput).sendKeys(passport);
    }

    public void fillBirthdayInput(LocalDate birthday) {
        driver.findElement(birthdayInput).sendKeys(String.valueOf(birthday.getDayOfMonth()));
        driver.findElement(birthdayInput).sendKeys(String.valueOf(birthday.getMonthValue()));
        driver.findElement(birthdayInput).sendKeys(String.valueOf(birthday.getYear()));
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }
}

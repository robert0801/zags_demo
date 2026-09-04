package steps;

import eu.senla.regoffice.models.AdminRegistrationDataDto;
import eu.senla.regoffice.pages.FillAdministratorDataPage;
import eu.senla.regoffice.utils.WebDriverManagerUtil;
import io.cucumber.java.en.When;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class FillAdministratorDataSteps {

    private final FillAdministratorDataPage fillAdministratorDataPage = new FillAdministratorDataPage(WebDriverManagerUtil.getDriver());

    @When("заполнить данные администратора данными:")
    public void fillAdminDataStep(Map<String, String> adminDataDto) {
        var adminRegistrationData = AdminRegistrationDataDto.builder()
                .personalLastName(adminDataDto.get("Фамилия"))
                .personalFirstName(adminDataDto.get("Имя"))
                .personalMiddleName(adminDataDto.get("Отчество"))
                .personalPhoneNumber(adminDataDto.get("Телефон"))
                .personalNumberOfPassport(adminDataDto.get("Номер паспорта"))
                .dateofbirth(LocalDate.parse(adminDataDto.get("Дата рождения"), DateTimeFormatter.ofPattern("dd.MM.yyyy")))
                .build();
        fillAdministratorDataPage.fillRegistrationData(adminRegistrationData);
    }

    @When("нажать кнопку 'Далее'")
    public void clickNextBtnStep() {
        fillAdministratorDataPage.clickNextBtn();
    }
}
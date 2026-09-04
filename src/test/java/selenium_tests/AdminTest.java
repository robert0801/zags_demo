package selenium_tests;

import eu.senla.regoffice.models.AdminRegistrationDataDto;
import eu.senla.regoffice.pages.RequestsPage;
import eu.senla.regoffice.pages.StartApplicationPage;
import eu.senla.regoffice.pages.FillAdministratorDataPage;
import eu.senla.regoffice.utils.WebDriverManagerUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class AdminTest {

    private WebDriver driver;

    @BeforeEach
    void initDriver() {
        driver = WebDriverManagerUtil.getDriver();
    }

    @Test
    void loginAsAdminTest() {
        var randomAdminRegistrationDataDto = AdminRegistrationDataDto.getRandomAdminRegistrationData();

        var startApplicationPage = new StartApplicationPage(driver);
        var fillAdministratorDataPage = new FillAdministratorDataPage(driver);
        var requestsPage = new RequestsPage(driver);

        startApplicationPage.openStartPage();
        startApplicationPage.clickAdminBtn();

        fillAdministratorDataPage.fillRegistrationData(randomAdminRegistrationDataDto);
        fillAdministratorDataPage.clickNextBtn();

        assertFalse(requestsPage.getRequestsTableRows().isEmpty());
    }

    @AfterEach
    void tearDown() {
        WebDriverManagerUtil.quitDriver();
    }
}

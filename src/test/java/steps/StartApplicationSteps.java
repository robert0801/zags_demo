package steps;

import eu.senla.regoffice.pages.StartApplicationPage;
import eu.senla.regoffice.utils.WebDriverManagerUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StartApplicationSteps {

    private final StartApplicationPage startApplicationPage = new StartApplicationPage(WebDriverManagerUtil.getDriver());

    @Given("открыть стартовую страницу")
    public void openStartApplicationPageStep() {
        startApplicationPage.openStartPage();
    }

    @When("нажать 'Войти как администратор'")
    public void clickLoginAsAdminStep() {
        startApplicationPage.clickAdminBtn();
    }
}
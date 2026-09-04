package steps;

import eu.senla.regoffice.pages.RequestsPage;
import eu.senla.regoffice.utils.WebDriverManagerUtil;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ListWithOrdersSteps {

    private final RequestsPage requestsPage = new RequestsPage(WebDriverManagerUtil.getDriver());

    @Then("список заявок для администратора не пустой")
    public void checkThatOrdersListNotEmptyStep() {
        assertFalse(requestsPage.getRequestsTableRows().isEmpty());
    }
}
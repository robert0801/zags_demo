package eu.senla.regoffice.pages;

import eu.senla.regoffice.components.RequestsTableRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RequestsPage extends BasePage {

    private final By row = By.cssSelector("table > tr[class*='MuiTableRow-root']");

    public RequestsPage(WebDriver driver) {
        super(driver);
    }

    public List<RequestsTableRow> getRequestsTableRows() {
        return driver.findElements(row)
                .stream().map(RequestsTableRow::new)
                .toList();
    }
}

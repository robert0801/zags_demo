package eu.senla.regoffice.pages;

import eu.senla.regoffice.components.RequestsTableRow;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class RequestsPage extends BasePage {

    private final By row = By.cssSelector("table > tr[class*='MuiTableRow-root']");

    public RequestsPage(WebDriver driver) {
        super(driver);
    }

    @SneakyThrows
    public List<RequestsTableRow> getRequestsTableRows() {
        Thread.sleep(1000);
        return driver.findElements(row)
                .stream().map(RequestsTableRow::new)
                .toList();
    }
}

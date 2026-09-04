package eu.senla.regoffice.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RequestsTableRow {

    private final WebElement rootElement;

    public RequestsTableRow(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    private final By requestNumber = By.xpath(".//td[1]");

    public String getRequestNumber() {
        return rootElement.findElement(requestNumber).getText();
    }
}

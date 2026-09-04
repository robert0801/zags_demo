package eu.senla.regoffice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartApplicationPage extends BasePage {

    public StartApplicationPage(WebDriver driver) {
        super(driver);
    }

    private final By adminBtn = By.xpath("//*[text()='Войти как администратор']");

    public void openStartPage() {
        driver.get("https://user:senlatest@regoffice.senla.eu/");
    }

    public void clickAdminBtn() {
        driver.findElement(adminBtn).click();
    }
}

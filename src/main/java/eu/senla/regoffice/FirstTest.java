package eu.senla.regoffice;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.util.Locale;

public class FirstTest {

    static void main() {
        Faker faker = new Faker(Locale.of("ru_RU"));
        LocalDate birthday = faker.timeAndDate().birthday();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://user:senlatest@regoffice.senla.eu/");
        driver.findElement(By.xpath("//*[text()='Войти как администратор']")).click();
        driver.findElement(By.id("TextInputField-1")).sendKeys(faker.name().lastName());
        driver.findElement(By.id("TextInputField-2")).sendKeys(faker.name().firstName());
        driver.findElement(By.id("TextInputField-3")).sendKeys(faker.name().firstName() + "вич");
        driver.findElement(By.cssSelector("[type='phone']")).sendKeys(faker.phoneNumber().phoneNumber());
        driver.findElement(By.id("TextInputField-5")).sendKeys(faker.passport().valid());
        driver.findElement(By.cssSelector("[type='date']")).sendKeys(String.valueOf(birthday.getDayOfMonth()));
        driver.findElement(By.cssSelector("[type='date']")).sendKeys(String.valueOf(birthday.getMonthValue()));
        driver.findElement(By.cssSelector("[type='date']")).sendKeys(String.valueOf(birthday.getYear()));
        driver.findElement(By.xpath("//*[text()='Далее']")).click();

        driver.quit();
    }
}

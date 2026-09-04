package steps;

import eu.senla.regoffice.utils.ScreenshotUtils;
import eu.senla.regoffice.utils.WebDriverManagerUtil;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HooksStep {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            attachScreenshot(scenario);
        }
        WebDriverManagerUtil.quitDriver();
    }

    private void attachScreenshot(Scenario scenario) {
        byte[] screenshot = ScreenshotUtils.takeScreenshot(WebDriverManagerUtil.getDriver());
        scenario.attach(
                screenshot,
                "image/png",
                "Screenshot on failure"
        );
    }
}
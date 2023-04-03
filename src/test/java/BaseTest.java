import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.slf4j.Slf4j;
import org.sauleqa.configs.TestConfig;
import org.sauleqa.pageobjects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class BaseTest extends TestConfig {

    LoginPage launchApp;

    @BeforeSuite
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }

    @BeforeMethod
    public LoginPage launchApp() {
        log.info("Launch application, open login page");
        open(UI_BASE_URL);
        log.info("Maximize browser window");
        WebDriverRunner.getWebDriver().manage().window().maximize();
        launchApp = new LoginPage();
        return launchApp;
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.clearBrowserCache();
        WebDriverRunner.closeWebDriver();
    }
}

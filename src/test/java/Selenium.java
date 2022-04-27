import Screens.DashboardPage;
import Screens.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import resources.Login;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Selenium {
    private WebDriver driver;
    private LoginPage loginPage;
    private static Login login= Login.builder().build();
    private DashboardPage dashboardPage;
    private static String info="Information";

    @BeforeAll
    public void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ws-test.keepit.com");
    }

    @AfterAll
    public void cleanUp(){
        driver.quit();
    }

    @Test
    @DisplayName("User should be able to create connector for Microsoft")
    public void seleniumExample(){
        loginPage=new LoginPage(driver);
        dashboardPage=new DashboardPage(driver);
        loginPage.setEmailInput(login.getLogin());
        loginPage.setPasswordInput(login.getPassword());
        loginPage.clickSignInBtn();
        dashboardPage.clickAddConnector();
        dashboardPage.clickMicrosoft();
        Assert.assertEquals(dashboardPage.getInformation(),info);
    }
}

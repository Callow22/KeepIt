package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;
    By addConnector=By.xpath("//div[@class='react-welcome-window-container']//div[@class='react-dropdown-menu']");
    By microsoft=By.xpath("//div[@class='dropdown-popup-content animation-out']//div[1]");
    By information=By.className("notification-header");

    public void clickAddConnector(){
        driver.findElement(addConnector).click();
    }
    public void clickMicrosoft(){
        driver.findElement(microsoft).click();
    }

    public String getInformation(){
        driver.findElement(information).isDisplayed();
        return driver.findElement(information).getText();
    }

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
}

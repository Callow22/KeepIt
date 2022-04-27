package Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By emailInput=By.name("login");
    By passwordInput= By.name("password");
    By signInBtn=By.id("login-form-login-button");

    public  void setEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSignInBtn(){
        driver.findElement(signInBtn).click();
    }

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

}

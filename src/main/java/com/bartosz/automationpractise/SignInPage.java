package com.bartosz.automationpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private final WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#email_create")
    private WebElement emailInput;
    @FindBy(css = "#SubmitCreate")
    private WebElement submitCreateButton;

    public void initiateRegistrationProcess(String emailAddress) {
        emailInput.sendKeys(emailAddress);
        submitCreateButton.click();
    }

}

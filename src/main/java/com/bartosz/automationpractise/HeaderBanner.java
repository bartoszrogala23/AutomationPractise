package com.bartosz.automationpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderBanner {
    private final WebDriver driver;

    public HeaderBanner(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login")
    private WebElement loginButton;
    @FindBy(css = "#contact-link")
    private WebElement contactUsButton;
    @FindBy(css = ".account")
    private WebElement account;

    public void goToLoginProcess() {
        loginButton.click();
    }

    public String getLoggedInUserName() {
        return account.getText();
    }





}
